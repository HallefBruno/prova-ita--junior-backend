package com.desafio_junior_backend.itau.estatistica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String ping() {
		return "<h3> :: API Estatistica Itaú V1 :: </h3>";
	}
	
}
