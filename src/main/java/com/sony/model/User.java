package com.sony.model;

import java.util.UUID;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String city;
	
	public User()
	{
		this.setId(UUID.randomUUID().toString());
	}
	public User(String firstName, String lastName, String city) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	
}
