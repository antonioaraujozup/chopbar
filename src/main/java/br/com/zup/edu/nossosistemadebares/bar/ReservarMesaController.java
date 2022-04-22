package br.com.zup.edu.nossosistemadebares.bar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ReservarMesaController {

    private final MesaRepository repository;

    public ReservarMesaController(MesaRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/mesas/{id}")
    @Transactional
    public ResponseEntity<?> reservar(@PathVariable Long id, @RequestBody @Valid ReservaMesaRequest request) {
        Mesa mesa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrada"));

        mesa.reservar(request.getReservadoPara());

        repository.save(mesa);

        return ResponseEntity.noContent().build();
    }
}
