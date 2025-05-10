package com.prueba.backend.router;

import com.prueba.backend.handler.FranquiciaHandler;
import com.prueba.backend.handler.ProductoHandler;
import com.prueba.backend.handler.SucursalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
@Slf4j
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(SucursalHandler sucursalHandler,
                                                FranquiciaHandler franquiciaHandler,
                                                ProductoHandler productoHandler){
        return RouterFunctions
                .route(POST("/sucursales"), sucursalHandler::anadirSucursal)
                .andRoute(PUT("/sucursales/{id}/name"), sucursalHandler::actualizarNombreSucursal)
                .andRoute(GET("/sucursales/{franquiciaId}"), sucursalHandler::getSucursalesByFranquiciaId)
                .andRoute(POST("/franquicias"), franquiciaHandler::anadirFranquicia)
                .andRoute(PUT("/franquicias/{id}/name"), franquiciaHandler::actualizarNombreFranquicia )
                .andRoute(GET("/franquicias/{id}"), franquiciaHandler::getFranquiciaById)
                .andRoute(POST("/productos"), productoHandler::anadirProducto)
                .andRoute(PUT("/productos/{id}/stock"), productoHandler::actualizarProductoStock)
                .andRoute(DELETE("/productos/{id}"), productoHandler::eliminarProducto)
                .andRoute(GET("/productos/maxStock/{sucursalId}"), productoHandler::getMaxStockProducto   )
                .andRoute(PUT("/productos/{id}/name"), productoHandler::actualizarNombreProducto);
    }
}
