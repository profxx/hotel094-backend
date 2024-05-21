package br.com.senai.hotel094.service;

import java.time.LocalDate;
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
    public Reserva novaReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }
    public Reserva update(Long id, Reserva reserva){
        Reserva reservaAtual = findById(id);
        reservaAtual.setQuartoId(reserva.getQuartoId());
        reservaAtual.setHospedeId(reserva.getHospedeId());
        reservaAtual.setStatus(reserva.getStatus());
        reservaAtual.setDataEntrada(reserva.getDataEntrada());
        reservaAtual.setDataSaida(reserva.getDataSaida());
        return reservaRepository.save(reservaAtual);
    }
    public Boolean deleteById(Long id){
        Reserva reserva = findById(id);
        if (reserva == null){
            return false;
        }else{
            reservaRepository.deleteById(id);
            return true;
        }
    }

}
