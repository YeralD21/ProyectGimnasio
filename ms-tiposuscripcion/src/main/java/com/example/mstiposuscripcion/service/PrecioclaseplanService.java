package com.example.mstiposuscripcion.service;

import com.example.mstiposuscripcion.entity.Clasegym;
import com.example.mstiposuscripcion.entity.Precioclaseplan;

import java.util.List;
import java.util.Optional;

public interface PrecioclaseplanService {
    public List<Precioclaseplan> listar();
    public Precioclaseplan guardar(Precioclaseplan precioclaseplan);
    public Precioclaseplan buscarPorId(Integer Id);
    public Precioclaseplan editar(Precioclaseplan precioclaseplan);
    public void eliminar(Integer Id);
}
