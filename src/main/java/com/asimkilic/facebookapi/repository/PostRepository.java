package com.asimkilic.facebookapi.repository;

import com.asimkilic.facebookapi.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface PostRepository extends CassandraRepository<Post, UUID> {
    ArrayList<Post> findAll();

    Post save(Post post);

    void deleteById(UUID id);
}
