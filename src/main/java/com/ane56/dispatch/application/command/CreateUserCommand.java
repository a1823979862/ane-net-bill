package com.ane56.dispatch.application.command;


public class CreateUserCommand {

	private String username;
	private String password;
	private String nikename;

	public CreateUserCommand(String username, String password, String nikename) {
		super();
		this.username = username;
		this.password = password;
		this.nikename = nikename;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNikename() {
		return nikename;
	}

}
