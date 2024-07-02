package br.gov.sp.fatec.domain.request;
import lombok.Builder;
import br.gov.sp.fatec.domain.enums.CarroStatus;


@Builder
public record CarroUpdateRequest(
    String modelo,
    String marca,
    int ano,
    CarroStatus status
) {}
