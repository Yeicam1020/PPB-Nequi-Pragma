package com.prueba.backend.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "franquicias")
@NoArgsConstructor
@AllArgsConstructor
public class Franquicia {

    @Id
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
