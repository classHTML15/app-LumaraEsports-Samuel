package com.fplumara.dam1.LumaraEsports.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipos {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La ciudad es obligatoria")
    private String ciudad;

    @NotNull(message = "El premio es obligatorio")
    @DecimalMin(value = "", message = "El premio debe ser mayor que 0")
    private BigDecimal premio;

    @NotNull(message = "Debes seleccionar un equipo campeon")
    private Long equipoCampeonId;
}
