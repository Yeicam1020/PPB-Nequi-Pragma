package com.prueba.backend.handler;

import com.prueba.backend.entidades.Sucursal;
import com.prueba.backend.service.SucursalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SucursalHandler {
    private final SucursalService sucursalService;

    public SucursalHandler(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public Mono<ServerResponse> anadirSucursal(ServerRequest request){
        return request.bodyToMono(Sucursal.class)
                .flatMap(sucursalService::anadirSucursal)
                .flatMap(sucursal -> ServerResponse.ok().bodyValue(sucursal));
    }

    public Mono<ServerResponse> actualizarNombreSucursal(ServerRequest request){
        Long sucursalId = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(String.class)
                .flatMap(newName -> sucursalService.actualizarNombreSucursal(sucursalId, newName))
                .flatMap(sucursal -> ServerResponse.ok().bodyValue(sucursal));
    }

    public Mono<ServerResponse> getSucursalesByFranquiciaId(ServerRequest request){
        Long franquiciaId = Long.valueOf(request.pathVariable("franquiciaId"));
        return sucursalService.getSucursalesByFranquiciaId(franquiciaId)
                .collectList()
                .flatMap(sucursales -> ServerResponse.ok().bodyValue(sucursales));
    }
}
