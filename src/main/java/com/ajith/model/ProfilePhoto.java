package com.ajith.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profile")
public class ProfilePhoto {

	@Id
	@Column(name = "profile id")
	private int id;
	@Column(name = "data",columnDefinition = "blob not null")
	private byte[] imageStream;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImageStream() {
		return imageStream;
	}

	public void setImageStream(byte[] imageStream) {
		this.imageStream = imageStream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "ProfilePhoto [id=" + id + ", imageStream="
				+ (imageStream != null
						? Arrays.toString(Arrays.copyOf(imageStream, Math.min(imageStream.length, maxLen)))
						: null)
				+ ", name=" + name + ", type=" + type + "]";
	}
}