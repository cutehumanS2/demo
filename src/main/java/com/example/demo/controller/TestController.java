package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("todo")
public class TestController {
	
	@Autowired
	private TodoService service;

	@GetMapping
	public String testController() {
		return "Hello World!(안녕하세요!)";
	}
	
	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required=false) int id) {
		return "Hello World! ID " + id;
	}
	
	@GetMapping("/Param")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello World! ID param " + id;
	}
	
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO requestDto) {
		return "Hello World! ID"+requestDto.getId()+"Message : "+requestDto.getMessage();
	}
	
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody(){
		List<String> list = new ArrayList<String>();
		list.add("Hellot World! I'm ResponseDTO");
		list.add("See you!");
		ResponseDTO<String> responseDTO = ResponseDTO.<String>builder()
													.data(list)
													.build();
		return responseDTO;
	}
	
	@GetMapping("/testResponseEntityOk")
	public ResponseEntity<?> testControllerResponseEntityOk(){
		List<String> list = new ArrayList<String>();
		list.add("Hello World! I'm ResponseEntity. And you get 200!");
		list.add("See you!");
		
		ResponseDTO<String> response = ResponseDTO.<String>builder()
									.data(list)
									.build();
		
		return ResponseEntity.ok().body(response);
		}
	
	@GetMapping("/testResponseEntityBad")
	public ResponseEntity<?> testControllerResponseEntityBad(){
	List<String> list = new ArrayList<String>();
	list.add("Hello World! I'm ResponseEntity. And you get 400!");
	list.add("See you!");
	
	ResponseDTO<String> response = ResponseDTO.<String>builder()
									.data(list)
									.build();
	
	return ResponseEntity.badRequest().body(response);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> testTodo(){
		String str = service.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		
		ResponseDTO<String> responseDTO = ResponseDTO.<String>builder()
											.data(list).build();
		
		return ResponseEntity.ok().body(responseDTO);
	}
}
