package com.prueba.backend.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Table(name = "sucursales")
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {

    @Id
    private Long id;
    private String nombre;
    @Column(value = "franquicia_id")
    private Long franquiciaId;

}
