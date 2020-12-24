package com.bms.project.models;

public class User {
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private int userAge;

	// Reference To Post Class
	Post postobj;

	public User() {
		
	}
	
	public User(int userId, String userName, String userEmail, String userPassword, int userAge) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAge = userAge;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	// Publish post Method
	
	   /**
	   * This method is used to publish new post.
	   */

	public void publishPost() {
		// To Do
	}

	// Edit post Method
	   /**
	   * This method is used to edit specific post.
	   * @param postId  This is the parameter to specific the post.
	   */

	public void editPost(int postId) {
		// To Do
	}

	// Delete post Method
	
	  /**
	   * This method is used to delete specific post.
	   * @param postId  This is the parameter to specific the post.
	   */

	public void deletePost(int postId) {
		// To Do
	}

}
