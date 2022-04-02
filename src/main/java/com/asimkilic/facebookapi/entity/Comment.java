package com.asimkilic.facebookapi.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table("comment")
public class Comment {

    @PrimaryKey
    private UUID commentID;

    private UUID postID;

    private UUID userID;

    private String comment;

    private Timestamp dateTime;

    public Comment() {
    }

    public Comment(UUID commentID, UUID postID, UUID userID, String comment, Timestamp dateTime) {
        this.commentID = commentID;
        this.postID = postID;
        this.userID = userID;
        this.comment = comment;
        this.dateTime = dateTime;
    }

    public UUID getCommentID() {
        return commentID;
    }

    public void setCommentID(UUID commentId) {
        this.commentID = commentId;
    }

    public UUID getPostID() {
        return postID;
    }

    public void setPostID(UUID postID) {
        this.postID = postID;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
