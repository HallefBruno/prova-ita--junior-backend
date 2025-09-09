package com.desafio_junior_backend.itau.estatistica.controller;

import com.desafio_junior_backend.itau.estatistica.model.dto.TransacaoDTO;
import com.desafio_junior_backend.itau.estatistica.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void salvar(@RequestBody(required = true) @Valid TransacaoDTO transacao) {
		transacaoService.salvar(transacao);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping
	public void excluirTransacoes() {
		transacaoService.excluir();
	}
	
}
