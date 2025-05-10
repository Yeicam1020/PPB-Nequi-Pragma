package com.prueba.backend.handler;

import com.prueba.backend.entidades.Producto;
import com.prueba.backend.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ProductoHandler {
    private final ProductoService productoService;

    public ProductoHandler(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Mono<ServerResponse> anadirProducto(ServerRequest request) {
        return request.bodyToMono(Producto.class)
                .flatMap(productoService::anadirProducto)
                .flatMap(producto -> ServerResponse.ok().bodyValue(producto));
    }

    public Mono<ServerResponse> actualizarProductoStock(ServerRequest request) {
        Long productoId = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(Long.class)
                .flatMap(newStock -> productoService.actualizarProductoStock(productoId, newStock))
                .flatMap(producto -> ServerResponse.ok().bodyValue(producto));
    }

    public Mono<ServerResponse> eliminarProducto(ServerRequest request) {
        Long productoId = Long.valueOf(request.pathVariable("id"));
        return productoService.eliminarProducto(productoId)
                .then(ServerResponse.noContent().build());
    }

    public Mono<ServerResponse> getMaxStockProducto(ServerRequest request) {
        Long sucursalId = Long.valueOf(request.pathVariable("sucursalId"));
        return productoService.getMaxStockProduct(sucursalId)
                .flatMap(producto -> ServerResponse.ok().bodyValue(producto))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> actualizarNombreProducto(ServerRequest request) {
        Long productoId = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(String.class)
                .flatMap(newName -> productoService.actualizarNombreProducto(productoId, newName))
                .flatMap(producto -> ServerResponse.ok().bodyValue(producto))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
