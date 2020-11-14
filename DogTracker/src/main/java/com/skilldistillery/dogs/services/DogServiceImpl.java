package com.skilldistillery.dogs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dogs.entites.Dog;
import com.skilldistillery.dogs.repositories.DogRepository;

@Service
public class DogServiceImpl implements DogService {
	
	@Autowired
	private DogRepository repo;

	@Override
	public List<Dog> getAllDogs() {
		
		return null;
	}

}
