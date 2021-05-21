package com.example.demo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyWriter implements ItemWriter<User>{
	
	@Autowired
	private UsersRepository repo;

	@Override
	@Transactional
	public void write(List<? extends User> users) throws Exception {

		System.out.println("Processing " + users.size() + "entries");
		repo.saveAll(users);
	}
	
}