package com.example.mstiposuscripcion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Precioclaseplan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clasegym_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Clasegym clasegym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_gym")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Plan plan;
}
