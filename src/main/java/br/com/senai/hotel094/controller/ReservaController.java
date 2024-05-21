package br.com.senai.hotel094.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.hotel094.entity.Reserva;
import br.com.senai.hotel094.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Reserva>> findAll(){
        List<Reserva> reservas = reservaService.findAll();
        return ResponseEntity.ok().body(reservas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id){
        Reserva reserva = reservaService.findById(id);
        return ResponseEntity.ok().body(reserva);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Reserva> novaReserva(@RequestBody Reserva reserva){
        Reserva reservaInserida = reservaService.novaReserva(reserva);
        return ResponseEntity.ok().body(reservaInserida);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva){
        Reserva reservaAlterada = reservaService.update(id, reserva);
        return ResponseEntity.ok().body(reservaAlterada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = reservaService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
    
    
}
