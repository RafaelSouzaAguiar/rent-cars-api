package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.CarroController;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarroControllerImpl implements CarroController {

    private final CarroService carroService;

    @Override
    public ResponseEntity<CarroResponse> save(CarroRequest carroRequest) {
        CarroResponse carro = carroService.save(carroRequest);
        return ResponseEntity.ok(carro);
    }

    @Override
    public ResponseEntity<CarroResponse> findById(Long id) {
        return ResponseEntity.ok(carroService.findById(id));
    }

    @Override
    public ResponseEntity<List<CarroResponse>> findAll() {
        return ResponseEntity.ok(carroService.findAll());
    }

    @Override
    public ResponseEntity<Void> updateById(Long id, CarroUpdateRequest request) {
        carroService.updateById(id, request);
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        carroService.deleteById(id);
        return null;
    }
}
