package com.prueba.backend.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "prodcutos")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private Long stock;
    private Long idSucursal;
    
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
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
    public Long getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }
}
