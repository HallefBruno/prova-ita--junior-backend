package com.desafio_junior_backend.itau.estatistica.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoDTO(
	@NotNull(message = "O valor é obrigatório")
	@Min(value = 0, message = "Valor mínimo é zero")
	BigDecimal valor,
	
	@NotNull(message = "Data hora é obrigatório")
	@PastOrPresent(message = "Data hora não pode ser no futuro")
	OffsetDateTime dataHora)
{
}
