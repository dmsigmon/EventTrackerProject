package com.skilldistillery.dogs.entites;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DogTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Dog dog;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("DogPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		dog = em.find(Dog.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dog = null;
	}

	@Test
	@DisplayName("test dog entity mapping")
	void test1() {
		assertNotNull(dog);
		assertEquals("Coda", dog.getName());
	}

}
