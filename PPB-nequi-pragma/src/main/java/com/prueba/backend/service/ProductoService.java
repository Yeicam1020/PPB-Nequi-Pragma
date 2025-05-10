package com.prueba.backend.service;

import com.prueba.backend.entidades.Producto;
import com.prueba.backend.repository.ProductoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductoService {
    private final ProductoRepo productoRepo;

    public ProductoService(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    public Mono<Producto> anadirProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    public Mono<Void> eliminarProducto(Long id) {
        return productoRepo.deleteById(id);
    }

    public Mono<Producto> actualizarProductoStock(Long productId, Long newStock) {
        return productoRepo.findById(productId)
                .flatMap(product -> {
                    product.setStock(newStock);
                    return productoRepo.save(product);
                });
    }

    public Flux<Producto> getProductosBySucursalId(Long branchId) {
        return productoRepo.findBySucursalId(branchId);
    }

    public Mono<Producto> getMaxStockProduct(Long branchId) {
        return productoRepo.findBySucursalId(branchId)
                .sort((p1, p2) -> Long.compare(p2.getStock(), p1.getStock()))
                .next();
    }

    public Mono<Producto> actualizarNombreProducto(Long productoId, String newName) {
        return productoRepo.findById(productoId)
                .flatMap(product -> {
                    product.setNombre(newName);
                    return productoRepo.save(product);
                });
    }
}
