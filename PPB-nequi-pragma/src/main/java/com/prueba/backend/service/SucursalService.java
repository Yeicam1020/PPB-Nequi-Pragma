package com.prueba.backend.service;

import com.prueba.backend.entidades.Sucursal;
import com.prueba.backend.repository.SucursalRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SucursalService {
    private final SucursalRepo sucursalRepo;

    public SucursalService(SucursalRepo sucursalRepo) {
        this.sucursalRepo = sucursalRepo;
    }

    public Mono<Sucursal> anadirSucursal(Sucursal sucursal) {
        return sucursalRepo.save(sucursal);
    }

    public Mono<Sucursal> findById(Long id) {
        return sucursalRepo.findById(id);
    }

    public Mono<Void> eliminarSucursal(Long id) {
        return sucursalRepo.deleteById(id);
    }

    public Mono<Sucursal> actualizarNombreSucursal(Long id, String newName) {
        return sucursalRepo.findById(id)
                .flatMap(sucursal -> {
                    sucursal.setNombre(newName);
                    return sucursalRepo.save(sucursal);
                });
    }

    public Flux<Sucursal> getSucursalesByFranquiciaId(Long franquiciaId) {
        return sucursalRepo.findByFranquicialId(franquiciaId);
    }
}
