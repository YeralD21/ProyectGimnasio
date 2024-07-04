package com.example.mstiposuscripcion.service;

import com.example.mstiposuscripcion.entity.Clasegym;

import java.util.List;
import java.util.Optional;

public interface ClasegymService {
    public List<Clasegym> listar();
    public Clasegym guardar(Clasegym clasegym);
    public Clasegym buscarPorId(Integer Id);
    public Clasegym editar(Clasegym clasegym);
    public void eliminar(Integer Id);
}
