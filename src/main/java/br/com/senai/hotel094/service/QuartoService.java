package br.com.senai.hotel094.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.hotel094.entity.Quarto;
import br.com.senai.hotel094.repository.QuartoRepository;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> findAll(){
        return quartoRepository.findAll();
    }
    public Quarto findById(Long id){
        return quartoRepository.findById(id).orElse(null);
    }
    public Quarto insertNew(Quarto quarto){
        return quartoRepository.save(quarto);
    }
    public Quarto update(Long id, Quarto quarto){
        Quarto quartoAtual = findById(id);
        quartoAtual.setTipo(quarto.getTipo());
        quartoAtual.setPreco(quarto.getPreco());
        quartoAtual.setCapacidade(quarto.getCapacidade());
        quartoAtual.setDisponibilidade(quarto.getDisponibilidade());
        return quartoRepository.save(quartoAtual);
    }
    public Boolean deleteById(Long id){
        Quarto quarto = findById(id);
        if (quarto == null){
            return false;
        }else{
            quartoRepository.deleteById(id);
            return true;
        }
    }
}
