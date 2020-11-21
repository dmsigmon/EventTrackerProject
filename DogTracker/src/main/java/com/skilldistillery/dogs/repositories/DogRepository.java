package com.skilldistillery.dogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dogs.entites.Dog;

public interface DogRepository extends JpaRepository<Dog, Integer> {
	

}
