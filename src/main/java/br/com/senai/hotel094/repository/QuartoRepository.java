package br.com.senai.hotel094.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.hotel094.entity.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long>{

}
