package com.asimkilic.facebookapi.controller;

import com.asimkilic.facebookapi.entity.Post;
import com.asimkilic.facebookapi.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/postService")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/save")
    public ArrayList<Post> submitPost(@RequestBody Post body) {
        ArrayList<Post> result = postService.submitPostToDB(body);
        return result;
    }

    @GetMapping("/getPost")
    public ArrayList<Post> retrieveAllPost() {
        ArrayList<Post> result = postService.retrievePostFromDb();
        return result;
    }

    @DeleteMapping("/delete/{postId}")
    public ArrayList<Post> deleteParticularPost(@PathVariable("postId") UUID postId) {
        ArrayList<Post> result = postService.deletePostFromDB(postId);
        return result;
    }
}
