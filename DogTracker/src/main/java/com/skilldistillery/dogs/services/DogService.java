package com.skilldistillery.dogs.services;

import java.util.List;

import com.skilldistillery.dogs.entites.Dog;

public interface DogService {
	List<Dog> getAllDogs();
	Dog create(Dog dog);
	Dog update(int dogId, Dog dog); 
	Dog showDog(int dogId);
	public boolean delete(int dogId);
}
