package com.asimkilic.facebookapi.controller;

import com.asimkilic.facebookapi.entity.Comment;
import com.asimkilic.facebookapi.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/commentService")
public class CommentController {
private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComments/{postID}")
    public ArrayList<Comment> retrieveAllComments(@PathVariable("postID") UUID postID) {
        return commentService.getallComment(postID);
    }



}
