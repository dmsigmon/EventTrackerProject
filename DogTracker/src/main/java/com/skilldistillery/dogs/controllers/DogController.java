package com.skilldistillery.dogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dogs.services.DogService;

@RestController
@RequestMapping("api")
public class DogController {

	@Autowired
	private DogService svc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
}
