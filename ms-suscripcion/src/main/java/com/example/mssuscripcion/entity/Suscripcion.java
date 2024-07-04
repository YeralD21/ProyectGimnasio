package com.example.mssuscripcion.entity;

import com.example.mssuscripcion.dto.ClasegymDto;
import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.dto.PlanDto;
import com.example.mssuscripcion.dto.PrecioclaseplanDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double precioTotal;
    private Date FechaInicio;
    private Date FechaFin;
    private Integer clientegymId;
    private Integer clasegymId;
    private Integer PrecioclaseplanId;



    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @Transient
    ClientesusDto clientesusDto;

    @Transient
    ClasegymDto clasegymDto;

    @Transient
    PrecioclaseplanDto precioclaseplanDto;




}
