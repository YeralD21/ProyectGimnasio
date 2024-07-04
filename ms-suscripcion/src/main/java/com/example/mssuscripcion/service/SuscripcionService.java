package com.example.mssuscripcion.service;

import com.example.mssuscripcion.entity.Suscripcion;

import java.util.List;

public interface SuscripcionService {
    public List<Suscripcion> listar();
    public Suscripcion guardar(Suscripcion suscripcion);
    public Suscripcion buscarPorId(Integer Id);
    public Suscripcion editar(Suscripcion suscripcion);
    public void eliminar(Integer Id);
}
