package com.bms.project.models;

public class Post {

	private int postId;
	private String postTitle;
	private String postContent;
	private String postDate;;

	public Post(int postId, String postTitle, String postContent, String postDate) {
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postTitle;
		this.postDate = postDate;

	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
}
