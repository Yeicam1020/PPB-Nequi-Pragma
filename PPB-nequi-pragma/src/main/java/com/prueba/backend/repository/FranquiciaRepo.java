package com.prueba.backend.repository;

import com.prueba.backend.entidades.Franquicia;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepo extends ReactiveCrudRepository<Franquicia, Long> {
}
