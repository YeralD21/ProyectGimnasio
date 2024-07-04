package com.example.mstiposuscripcion.service;

import com.example.mstiposuscripcion.entity.Clasegym;
import com.example.mstiposuscripcion.entity.Plan;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    public List<Plan> listar();
    public Plan guardar(Plan plan);
    public Plan buscarPorId(Integer Id);
    public Plan editar(Plan plan);
    public void eliminar(Integer Id);
}
