package com.skilldistillery.dogs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dogs.entites.Dog;
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
	
	@GetMapping("dogs")
	public List<Dog> listDogs(){
		return svc.getAllDogs();
	}
	
	@GetMapping("dogs/{dogId}")
	public Dog showDog(@PathVariable Integer dogId, HttpServletResponse response ) {
		Dog dog = svc.showDog(dogId);
		if (dog == null ) {
			response.setStatus(404);
		}
		return dog;
	}

	@PostMapping("dogs")
	public Dog create(@RequestBody Dog dog, HttpServletResponse response, HttpServletRequest request){
		
		try {
			svc.create(dog);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(dog.getId());
			response.setHeader("Location", url.toString());
		} catch (Exception e) {
			dog = null;
			response.setStatus(400);
		}
		return dog;
	}
	
	@PutMapping("dogs/{dogId}")
	public Dog update(@PathVariable Integer dogId, @RequestBody Dog dog, HttpServletResponse repsonse, HttpServletRequest request) {
		try {
			dog = svc.update(dogId, dog);
			if(dog == null) {
				repsonse.setStatus(404);
			}
		} catch (Exception e) {
			repsonse.setStatus(400);
			dog = null;
		}
		return dog;
	}
	
	@DeleteMapping("dogs/{dogId}")
	public void deleteDog(@PathVariable Integer dogId, HttpServletResponse response) {
		try {
			if (svc.delete(dogId)) {
				response.setStatus(204);
			}else {
				response.setStatus(404);
			}
			
		} catch (Exception e) {
			response.setStatus(400);
		}
	}	
}
