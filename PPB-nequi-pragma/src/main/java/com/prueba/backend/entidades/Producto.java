package com.prueba.backend.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private Long stock;
    @Column(value = "sucursal_id")
    private Long sucursalId;

}
