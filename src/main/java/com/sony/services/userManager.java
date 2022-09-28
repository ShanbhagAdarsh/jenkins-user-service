package com.sony.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sony.model.User;

@Service
public class userManager {
	private Map<String,User> users ;
	
	
	public userManager()
	{
		users = new LinkedHashMap<>();
		
		User user = new User("Adarsh","Shanbhag","karwar");
		users.put(user.getId(),user);
		
		user = new User("Gagandeep","Ramgiri","Dharwad");
		users.put(user.getId(),user);
		
		user = new User("Suraj","Meharvad","Hubli");
		users.put(user.getId(),user);
		
		user = new User("suchit","shetty","Hassan");
		users.put(user.getId(),user);
		
	}
	
	public Iterable<User> getllUsers()
	{
		return this.users.values();
	}
	public User getUserById(String Id)
	{
		return this.users.get(Id);
	}
	
}
