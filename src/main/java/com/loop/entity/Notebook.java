package com.loop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notebook implements Serializable{
	private static final long serialVersionUID = -8341731366267651270L;
	
	private String id;
	private String name;
	private String typeId;
	private String userId;
	private String description;
	private Timestamp timeCreated;

	public Notebook() {
	}

	public Notebook(String id, String name, String typeId, String userId, String description, Timestamp timeCreated) {
		this.id = id;
		this.name = name;
		this.typeId = typeId;
		this.userId = userId;
		this.description = description;
		this.timeCreated = timeCreated;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "Notebook{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", typeId='" + typeId + '\'' +
				", userId='" + userId + '\'' +
				", description='" + description + '\'' +
				", timeCreated=" + timeCreated +
				'}';
	}
}
