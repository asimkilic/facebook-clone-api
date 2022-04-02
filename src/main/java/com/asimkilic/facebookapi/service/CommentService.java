package com.asimkilic.facebookapi.service;

import com.asimkilic.facebookapi.entity.Comment;
import com.asimkilic.facebookapi.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService {


    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime = new Timestamp(time);
        comment.setCommentID(UUID.randomUUID());
        comment.setDateTime(dateTime);
        Comment result = commentRepository.save(comment);
        return result;
    }

    public ArrayList<Comment> getallComment(UUID postID) {

        ArrayList<Comment> allComments = commentRepository.findAllByPostID(postID);
        return allComments;
    }

}
