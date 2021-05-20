package com.ar24388.projects.backendService.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ar24388.projects.backendService.model.User;
import com.ar24388.projects.backendService.model.UserLogin;
import com.ar24388.projects.backendService.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User userdata)
	{
		String Response="";
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		try {
			userRepo.save(userdata);
			Response = "Success";
		}
		catch(Exception e)
		{
			Response = "Failed";
		}
		return ResponseEntity.created(uri).body(Response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLogin logindata)
	{
		String Response="";
		String username =logindata.getUsername();
		String password =logindata.getPassword();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		try{
			if(!userRepo.findByUsername(username).getPassword().equals(null)) {
				if(password.equals(userRepo.findByUsername(username).getPassword())) {
					Response = "Access granted";
				}
				else
				{
					Response ="Access Denied";
				}
			}
			else
			{
				Response ="Access Denied";
			}
		}
		catch(Exception e) {
			Response = "Access Denied";
		}
		return ResponseEntity.created(uri).body(Response);
	}
	

}
