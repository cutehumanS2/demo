package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {

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
	
}
