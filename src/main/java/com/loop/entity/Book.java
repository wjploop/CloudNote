package com.loop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * author  loop
 * create  2018-02-01 09:07.
 */


public class Book implements Serializable{
    private String id;
    private String userId;
    private String typeId;
    private String name;
    private String description;
    private Timestamp timeCreated;

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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
