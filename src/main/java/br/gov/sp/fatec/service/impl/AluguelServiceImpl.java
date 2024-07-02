package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        return aluguelMapper.map(aluguelRepository.save(aluguelMapper.map(aluguelRequest)));
    }

    @Override
    public AluguelResponse findById(Long id) {
        return aluguelMapper.map(aluguelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado")));
    }
    
    public Aluguel getById(Long id){
        return aluguelRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Aluguel não encontrado com id: " + id)
        );
    }

    @Override
    public List<AluguelResponse> findAll() {
        List<Aluguel> aluguels = aluguelRepository.findAll();
        return aluguels.stream().map(aluguelMapper::map).toList();
    }

    @Transactional
    @Override
    public void updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {
        Aluguel aluguel = getById(id);
        aluguel.setDataInicio(aluguelUpdateRequest.dataInicio());
        aluguel.setDataFim(aluguelUpdateRequest.dataFim());
        aluguel.setValor(aluguelUpdateRequest.valor());
        aluguel.setStatus(aluguelUpdateRequest.status());
        aluguel.setCarro_id(aluguelUpdateRequest.carro_id());
        aluguel.setCliente_id(aluguelUpdateRequest.cliente_id());
        aluguelRepository.save(aluguel);
    }

    @Override
    public void deleteById(Long id) {
        Aluguel aluguel = aluguelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
        aluguelRepository.delete(aluguel);
    }
}
