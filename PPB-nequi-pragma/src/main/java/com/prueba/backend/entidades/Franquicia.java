package com.prueba.backend.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Table(name = "franquicias")
@NoArgsConstructor
@AllArgsConstructor
public class Franquicia {

    @Id
    private Long id;
    private String nombre;

}
