package com.desafio_junior_backend.itau.estatistica.controller;

import com.desafio_junior_backend.itau.estatistica.model.Estatistica;
import com.desafio_junior_backend.itau.estatistica.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
	
	@Autowired
	private EstatisticaService estatisticaService;
	
	@GetMapping
	public Estatistica getEstatistica() {
		return ResponseEntity.ok(estatisticaService.getEstatistica()).getBody();
	}
	
}
