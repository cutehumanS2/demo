package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public String testService() {
		//return "Test Service";
		// Todo Entity 생성
		TodoEntity entity = TodoEntity.builder()
				.userId("Choi Ga Hui")
				.title("My first todo item")
				.build();
				
		// Todo Entity 저장
		repository.save(entity);
		
		// Todo Entity 검색
		//TodoEntity savedEntity = repository.findByUserId(entity.getUserId()).get(0);
		TodoEntity savedEntity = repository.searchByUserId(entity.getUserId()).get(0);
		
		return savedEntity.getUserId();
	}

}
