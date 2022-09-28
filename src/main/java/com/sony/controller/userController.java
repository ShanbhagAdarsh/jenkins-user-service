package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.User;
import com.sony.services.userManager;

@RestController
@RequestMapping("api/users")
public class userController {
	
	@Autowired
	private userManager mgr;
	
	@GetMapping
	public Iterable<User> handlegetall()
	{
		return mgr.getllUsers();
	}
	
	@GetMapping(path = "/{Id}",produces = "application/json" )
	public ResponseEntity<Object> getbyId(@PathVariable String Id)
	{
		User obj = mgr.getUserById(Id);
		if(obj == null)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(obj);
		}
	}

}
