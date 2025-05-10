package com.prueba.backend.repository;

import com.prueba.backend.entidades.Sucursal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SucursalRepo extends ReactiveCrudRepository<Sucursal, Long> {
    Flux<Sucursal> findByFranquicialId(Long franquicialId);
}
