package com.desafio_junior_backend.itau.estatistica.service;

import com.desafio_junior_backend.itau.estatistica.utils.CacheUtils;
import com.desafio_junior_backend.itau.estatistica.model.Estatistica;
import com.desafio_junior_backend.itau.estatistica.model.Transacao;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {
	
	private final CacheUtils<Transacao> cacheUtils = CacheUtils.getInstance();
	
	public Estatistica getEstatistica() {
		List<Transacao> transacaos = cacheUtils.getChache();
		if(!transacaos.isEmpty()) {
			OffsetDateTime dataHoraSistema = OffsetDateTime.now();
			int ultimoMinutoHoraAtual = dataHoraSistema.getMinute();
			BigDecimal sum;
			BigDecimal avg;
			BigDecimal min;
			BigDecimal max;
			
			List<BigDecimal> calc = new ArrayList<>();
			
			for(Transacao t : transacaos) {
				if(t.getDataHoraInclusao().getMinute() == ultimoMinutoHoraAtual) {
					calc.add(t.getValor());
				}
			}
			
			if(!calc.isEmpty()) {
				sum = calc.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
				avg = sum.divide(new BigDecimal(calc.size()));
				min = Collections.min(calc);
				max = Collections.max(calc);
				return new Estatistica(calc.size(), sum, avg, min, max);
			}
		}
		return new Estatistica(0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
	}
	
}
