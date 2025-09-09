package com.desafio_junior_backend.itau.estatistica.service;

import com.desafio_junior_backend.itau.estatistica.utils.CacheUtils;
import com.desafio_junior_backend.itau.estatistica.model.Transacao;
import com.desafio_junior_backend.itau.estatistica.model.dto.TransacaoDTO;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
	
	private final CacheUtils<Transacao> cacheUtils = CacheUtils.getInstance();
	
	public void salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = new Transacao(transacaoDTO.valor(), transacaoDTO.dataHora(), LocalDateTime.now());
		cacheUtils.addCache(transacao);
	}
	
	public void excluir() {
		cacheUtils.limparCache();
	}
	
}
