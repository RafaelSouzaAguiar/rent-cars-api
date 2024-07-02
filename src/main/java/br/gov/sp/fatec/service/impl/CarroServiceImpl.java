package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    public CarroResponse save(CarroRequest carroRequest) {
        return carroMapper.map(carroRepository.save(carroMapper.map(carroRequest)));
    }

    @Override
    public CarroResponse findById(Long id) {
        return carroMapper.map(carroRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado")));
    }

    public Carro getById(Long id){
        return carroRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Carro não encontrado com id: " + id)
        );
    }

    @Override
    public List<CarroResponse> findAll() {
        List<Carro> carros = carroRepository.findAll();
        return carros.stream().map(carroMapper::map).toList();
    }

    @Override
    public void updateById(Long id, CarroUpdateRequest carroUpdateRequest) {
        Carro carro = getById(id);
        carro.setModelo(carroUpdateRequest.modelo());
        carro.setMarca(carroUpdateRequest.marca());
        carro.setAno(carroUpdateRequest.ano());
        carro.setStatus(carroUpdateRequest.status());
        carroRepository.save(carro);
    }

    @Override
    public void deleteById(Long id) {
        Carro carro = carroRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        carroRepository.delete(carro);
    }
}
