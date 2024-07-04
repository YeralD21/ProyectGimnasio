package com.example.mssuscripcion.dto;

import lombok.Data;
import lombok.Setter;

@Data

public class PrecioclaseplanDto {
    private Integer id;
    private Double precio;
    private PlanDto plan;
    private ClasegymDto clasegymDto;
}