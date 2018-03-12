package com.loop.entity;

import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.sql.Timestamp;

public class Note implements Serializable {
    private static final long serialVersionUID = -8176239102696538864L;

    private String id;
    private String notebookId;
    private String userId;
    private String statusId;
    private String typeId;
    private boolean share;
    private String title;
    private String body;
    private Timestamp timeCreated;
    private Timestamp timeLastModified;

    public Note() {
    }

    public Note(String id, String notebookId, String userId, String statusId, String typeId, boolean share, String title, String body, Timestamp timeCreated, Timestamp timeLastModified) {
        this.id = id;
        this.notebookId = notebookId;
        this.userId = userId;
        this.statusId = statusId;
        this.typeId = typeId;
        this.share = share;
        this.title = title;
        this.body = body;
        this.timeCreated = timeCreated;
        this.timeLastModified = timeLastModified;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(String notebookId) {
        this.notebookId = notebookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeLastModified() {
        return timeLastModified;
    }

    public void setTimeLastModified(Timestamp timeLastModified) {
        this.timeLastModified = timeLastModified;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", notebookId='" + notebookId + '\'' +
                ", userId='" + userId + '\'' +
                ", statusId='" + statusId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", share=" + share +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", timeCreated=" + timeCreated +
                ", timeLastModified=" + timeLastModified +
                '}';
    }
}
