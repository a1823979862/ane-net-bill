package com.ane56.dispatch.domain.user;

import java.util.Date;

public class User {

	private long id;
	private String username;
	private String password;
	private String nikename;
	private Date created;
	private boolean status;

	public User() {
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
