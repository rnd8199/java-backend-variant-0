package com.ar24388.projects.frontendService.model;

public class User {
	
	private Integer Id;
	private String username;
	private String password;
	private String emailid;
	private String contact;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String username, String password, String emailid, String contact) {
		super();
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.contact = contact;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", username=" + username + ", password=" + password + ", emailid=" + emailid
				+ ", contact=" + contact + "]";
	}
	
	
	
}
