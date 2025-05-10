package com.prueba.backend.cofiguracion;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

public class ConfiguracionBD {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                "r2dbc:mysql://conection"
        );
    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }
}
