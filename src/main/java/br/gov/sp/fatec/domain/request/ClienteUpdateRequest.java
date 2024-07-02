package br.gov.sp.fatec.domain.request;
import lombok.Builder;

@Builder
public record ClienteUpdateRequest(
        String nome,
        String telefone,
        String cpf
) {}
