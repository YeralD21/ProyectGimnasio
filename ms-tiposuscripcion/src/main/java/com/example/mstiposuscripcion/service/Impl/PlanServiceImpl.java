package com.example.mstiposuscripcion.service.Impl;

import com.example.mstiposuscripcion.entity.Plan;
import com.example.mstiposuscripcion.repository.PlanRepository;
import com.example.mstiposuscripcion.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;
    @Override
    public List<Plan> listar() {
        return planRepository.findAll();
    }

    @Override
    public Plan guardar(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan buscarPorId(Integer id) {
        return planRepository.findById(id).get();
    }

    @Override
    public Plan editar(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void eliminar(Integer id) {
        planRepository.deleteById(id);
    }
    }

