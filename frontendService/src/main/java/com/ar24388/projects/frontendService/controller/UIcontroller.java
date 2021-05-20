package com.ar24388.projects.frontendService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.ar24388.projects.frontendService.model.Login;
import com.ar24388.projects.frontendService.model.User;

@Controller
public class UIcontroller {
	
	String url = "http://Eureka-client-2";
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
	      return new RestTemplate();
	  }
	
	@Autowired
	private RestTemplate rest;
	
	@GetMapping("/")
	public String welcome()
	{
		return "welcome";
	}

	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	/*
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	@GetMapping("/success")
	public String success()
	{
		return "success";
	}
	@GetMapping("/failure")
	public String failure()
	{
		return "failure";
	}
	*/
	@PostMapping("/register")
	public String registernew(@RequestBody User user)
	{		
		HttpEntity<Object> request = new HttpEntity<>(user);
		ResponseEntity<String> response = rest.exchange(url+"/register", HttpMethod.POST, request, String.class);
		
		if(response.getBody().contains("Failed"))
		{
			return "failure";
		}
		else
		{
			return "login";
		}

	}
	@PostMapping("/login")
	public String registernew(@RequestBody Login login)
	{
		HttpEntity<Object> request = new HttpEntity<>(login);
		ResponseEntity<String> response = rest.exchange(url+"/register", HttpMethod.POST, request, String.class);
		
		if(response.getBody().contains("Access Denied"))
		{
			return "failure";
		}
		else
		{
			return "dashboard";
		}

	}

}
