package com.blogify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogify.repository.UserRepo;

@SpringBootTest
class BlogifyTests {
	
	@Autowired
	private UserRepo uRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String name = uRepo.getClass().getName();
		String packageName = uRepo.getClass().getPackageName();
		System.out.println("Repository Name = " + name);
		System.out.println("Package Name = " + packageName);
	}

}
