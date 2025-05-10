package com.prueba.backend.handler;

import com.prueba.backend.entidades.Franquicia;
import com.prueba.backend.service.FranquiciaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class FranquiciaHandler {
    private final FranquiciaService franquiciaService;

    public FranquiciaHandler(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    public Mono<ServerResponse> anadirFranquicia(ServerRequest request){
        return request.bodyToMono(Franquicia.class)
                .flatMap(franquiciaService::anadirFranquicia)
                .flatMap(franquicia -> ServerResponse.ok().bodyValue(franquicia));
    }

    public Mono<ServerResponse> actualizarNombreFranquicia(ServerRequest request){
        Long franquiciaId = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(String.class)
                .flatMap(newName -> franquiciaService.actualizarNombreFranquicia(franquiciaId, newName))
                .flatMap(franquicia -> ServerResponse.ok().bodyValue(franquicia));
    }

    public Mono<ServerResponse> getFranquiciaById(ServerRequest request) {
        Long franquiciaId = Long.valueOf(request.pathVariable("id"));
        return franquiciaService.findById(franquiciaId)
                .flatMap(franquicia -> ServerResponse.ok().bodyValue(franquicia))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
