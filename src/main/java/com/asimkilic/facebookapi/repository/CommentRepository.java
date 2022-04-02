package com.asimkilic.facebookapi.repository;

import com.asimkilic.facebookapi.entity.Comment;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface CommentRepository extends CassandraRepository<Comment, UUID> {

    @AllowFiltering
    ArrayList<Comment> findAllByPostID(UUID postID);
}
