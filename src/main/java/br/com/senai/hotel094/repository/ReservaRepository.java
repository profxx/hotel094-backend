package br.com.senai.hotel094.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.hotel094.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
