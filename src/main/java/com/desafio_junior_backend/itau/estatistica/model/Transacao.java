package com.desafio_junior_backend.itau.estatistica.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

//@Entity
public class Transacao {
	
	private BigDecimal valor;
	private OffsetDateTime dataHora;
	private LocalDateTime dataHoraInclusao;

	public Transacao(BigDecimal valor, OffsetDateTime dataHora, LocalDateTime dataHoraInclusao) {
		this.valor = valor;
		this.dataHora = dataHora;
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public Transacao() {
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	@Override
	public String toString() {
		return "Transacao{" + "valor=" + valor + ", dataHora=" + dataHora + ", dataHoraInclusao=" + dataHoraInclusao + '}';
	}
	
}