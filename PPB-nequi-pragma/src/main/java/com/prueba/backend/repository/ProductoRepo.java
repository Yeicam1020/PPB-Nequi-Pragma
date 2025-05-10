package com.prueba.backend.repository;

import com.prueba.backend.entidades.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductoRepo extends ReactiveCrudRepository<Producto, Long> {
    Flux<Producto> findBySucursalId(Long sucursalId);
}
