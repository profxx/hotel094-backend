package br.com.senai.hotel094.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.hotel094.entity.Hospede;
import br.com.senai.hotel094.repository.HospedeRepository;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public List<Hospede> findAll(){
        return hospedeRepository.findAll();
    }
    public Hospede findById(Long id){
        return hospedeRepository.findById(id).orElse(null);
    }
    public Hospede insertNew(Hospede hospede){
        return hospedeRepository.save(hospede);
    }
    public Hospede update(Long id, Hospede hospede){
        Hospede hospedeAtual = findById(id);
        hospedeAtual.setNome(hospede.getNome());
        hospedeAtual.setEmail(hospede.getEmail());
        hospedeAtual.setTelefone(hospede.getTelefone());
        hospedeAtual.setEndereco(hospede.getEndereco());
        return hospedeRepository.save(hospedeAtual);
    }
    public Boolean deleteById(Long id){
        Hospede hospede = findById(id);
        if (hospede == null){
            return false;
        }else{
            hospedeRepository.deleteById(id);
            return true;
        }
    }
}
