package com.prueba.backend.service;

import com.prueba.backend.entidades.Franquicia;
import com.prueba.backend.repository.FranquiciaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FranquiciaService {
    private final FranquiciaRepo franquiciaRepo;

    public FranquiciaService(FranquiciaRepo franquiciaRepo) {
        this.franquiciaRepo = franquiciaRepo;
    }

    public Mono<Franquicia> anadirFranquicia(Franquicia franquicia) {
        return franquiciaRepo.save(franquicia);
    }

    public Mono<Franquicia> findById(Long id) {
        return franquiciaRepo.findById(id);
    }

    public Mono<Void> eliminarFranquicia(Long id) {
        return franquiciaRepo.deleteById(id);
    }

    public Mono<Franquicia> actualizarNombreFranquicia(Long id, String newName) {
        return franquiciaRepo.findById(id)
                .flatMap(franquicia -> {
                    franquicia.setNombre(newName);
                    return franquiciaRepo.save(franquicia);
                });
    }

    public Flux<Franquicia> getAllFranquicias() {
        return franquiciaRepo.findAll();
    }
}
