package com.loop.entity;

import java.util.Date;

/**
 * author  loop
 * create  2018-02-03 11:40.
 */


public class Note {
    private String id;
    private String userId;
    private String bookId;
    private String typeId;
    private String stateId;
    private String title;
    private String content;
    private Date timeCreated;
    private Date timeLastModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeLastModified() {
        return timeLastModified;
    }

    public void setTimeLastModified(Date timeLastModified) {
        this.timeLastModified = timeLastModified;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", stateId='" + stateId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                ", timeLastModified=" + timeLastModified +
                '}';
    }
}
