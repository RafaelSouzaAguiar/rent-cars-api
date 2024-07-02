package br.gov.sp.fatec.domain.request;
import br.gov.sp.fatec.domain.enums.AluguelStatus;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import java.util.Date;
import lombok.Builder;

@Builder
public record AluguelUpdateRequest(
    Date dataInicio,
    Date dataFim,
    double valor,
    AluguelStatus status,
    Long carro_id,
    Long cliente_id
) {}
