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

import br.com.senai.hotel094.entity.Quarto;
import br.com.senai.hotel094.service.QuartoService;

@RestController
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Quarto>> findAll(){
        List<Quarto> quartos = quartoService.findAll();
        return ResponseEntity.ok().body(quartos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Long id){
        Quarto quarto = quartoService.findById(id);
        return ResponseEntity.ok().body(quarto);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Quarto> insertNew(@RequestBody Quarto quarto){
        Quarto quartoInserido = quartoService.insertNew(quarto);
        return ResponseEntity.ok().body(quartoInserido);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Quarto> update(@PathVariable Long id, @RequestBody Quarto quarto){
        Quarto quartoAlterado = quartoService.update(id, quarto);
        return ResponseEntity.ok().body(quartoAlterado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = quartoService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }

}
