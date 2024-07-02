package br.gov.sp.fatec.domain.response;
import br.gov.sp.fatec.domain.enums.AluguelStatus;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import java.util.Date;

public record AluguelResponse(
    Date dataInicio,
    Date dataFim,
    double valor,
    AluguelStatus status,
    Long carro_id,
    Long cliente_id
) {}
