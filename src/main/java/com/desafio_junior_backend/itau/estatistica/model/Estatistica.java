package com.desafio_junior_backend.itau.estatistica.model;

import java.math.BigDecimal;


public record Estatistica(
	Integer count,
	BigDecimal sum,
	BigDecimal avg,
	BigDecimal min,
	BigDecimal max)
{
} 