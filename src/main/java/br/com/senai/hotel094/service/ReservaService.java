package br.com.senai.hotel094.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.hotel094.entity.Quarto;
import br.com.senai.hotel094.entity.Reserva;
import br.com.senai.hotel094.repository.QuartoRepository;
import br.com.senai.hotel094.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private QuartoRepository quartoRepository;

    public List<Reserva> findAll(){
        return reservaRepository.findAll();
    }
    public Reserva findById(Long id){
        return reservaRepository.findById(id).orElse(null);
    }
    public Reserva insertNew(Reserva reserva){
        Quarto quarto = quartoRepository.findById(reserva.getQuartoId()).orElse(null);
        if (quarto != null){
            quarto.setDisponibilidade("reservado");
        }
        return reservaRepository.save(reserva);
    }

}
