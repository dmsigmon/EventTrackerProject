package com.skilldistillery.dogs.services;

import java.util.List;
import java.util.Optional;

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
		return repo.findAll();
	}

	@Override
	public Dog create(Dog dog) {
		repo.saveAndFlush(dog);
		return dog;
	}

	@Override
	public Dog update(int dogId, Dog dog) {
		Optional<Dog> dogOpt = repo.findById(dogId);

		Dog updatedDog = null;

		if (dogOpt.isPresent()) {
			updatedDog = dogOpt.get();
			
			if (dog.getAggressive() != null) {
				updatedDog.setAggressive(dog.getAggressive());
			}
			if (dog.getBreed() != null) {
				updatedDog.setBreed(dog.getBreed());
			}
			if (dog.getDescription() != null) {
				updatedDog.setDescription(dog.getDescription());
			}
			if (dog.getImageUrl() != null) {
				updatedDog.setImageUrl(dog.getImageUrl());
			}
			if (dog.getName() != null) {
				updatedDog.setName(dog.getName());
			}
			if (dog.getSize() != null) {
				updatedDog.setSize(dog.getSize());
			}
			repo.flush();
		}
		return updatedDog;
	}

	@Override
	public Dog showDog(int dogId) {
		Optional<Dog> dogOpt = repo.findById(dogId);
		Dog dog = null;
		if (dogOpt.isPresent()) {
			dog = dogOpt.get();
		}
		return dog;
	}

	@Override
	public boolean delete(int dogId) {
		boolean deleted = false;
		Optional<Dog> dogDeleted = repo.findById(dogId);
		if (dogDeleted.isPresent()) {
			repo.delete(dogDeleted.get());
			deleted = true;
		}
		return deleted;
	}
}
