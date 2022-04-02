package com.asimkilic.facebookapi.service;

import com.asimkilic.facebookapi.entity.Post;
import com.asimkilic.facebookapi.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public ArrayList<Post> submitPostToDB(Post postData) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime = new Timestamp(time);
        postData.setPostId(UUID.randomUUID());
        postData.setLikes(0);
        postData.setDateTime(dateTime);
        postRepository.save(postData);
        ArrayList<Post> allPosts = retrievePostFromDb();
        return allPosts;
    }

    public ArrayList<Post> retrievePostFromDb() {
        ArrayList<Post> allPosts = postRepository.findAll();
        return allPosts;
    }


    public ArrayList<Post> deletePostFromDB(UUID postId) {
        postRepository.deleteById(postId);
        ArrayList<Post> allPosts = retrievePostFromDb();
        return allPosts;
    }
}
