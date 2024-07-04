package com.example.mssuscripcion.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ClasegymDto {
    private Integer id;
    private String tipoclase; // zumba, X-Box, baile, musculación
    private Integer cuposDisponibles;
    private PlanDto plan;
}
