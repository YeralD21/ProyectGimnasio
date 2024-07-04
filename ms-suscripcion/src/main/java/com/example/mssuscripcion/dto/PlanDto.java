package com.example.mssuscripcion.dto;

import lombok.Data;

@Data

public class PlanDto {
    private Integer id;
    private String tiempo; // Mensual, Trimestral, Anual
}