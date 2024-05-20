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

import br.com.senai.hotel094.entity.Hospede;
import br.com.senai.hotel094.service.HospedeService;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Hospede>> findAll(){
        List<Hospede> hospedes = hospedeService.findAll();
        return ResponseEntity.ok().body(hospedes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Long id){
        Hospede hospede = hospedeService.findById(id);
        return ResponseEntity.ok().body(hospede);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Hospede> insertNew(@RequestBody Hospede hospede){
        Hospede hospedeInserido = hospedeService.insertNew(hospede);
        return ResponseEntity.ok().body(hospedeInserido);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hospede> update(@PathVariable Long id, @RequestBody Hospede hospede){
        Hospede hospedeAtualizado = hospedeService.update(id, hospede);
        return ResponseEntity.ok().body(hospedeAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = hospedeService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
