package org.doInSpringBoot.restservices.restfulwebservices.responsebeans;

import java.util.Date;

public class Posts {

	private Integer postId;
	private Date postCreationTime;
	private User postCreatedBy;
	
	public Posts() {}
	
	public Posts(Integer postId, Date postCreationTime, User postCreatedBy) {
		super();
		this.postId = postId;
		this.postCreationTime = postCreationTime;
		this.postCreatedBy = postCreatedBy;
	}
	
	public Integer getPostId() {
		return postId;
	}
	
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	public Date getPostCreationTime() {
		return postCreationTime;
	}
	
	public void setPostCreationTime(Date postCreationTime) {
		this.postCreationTime = postCreationTime;
	}
	
	public User getPostCreatedBy() {
		return postCreatedBy;
	}
	
	public void setPostCreatedBy(User postCreatedBy) {
		this.postCreatedBy = postCreatedBy;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", postCreationTime=" + postCreationTime + ", postCreatedBy=" + postCreatedBy
				+ "]";
	}
	
}
