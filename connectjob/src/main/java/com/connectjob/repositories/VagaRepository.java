package com.connectjob.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectjob.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{

}
