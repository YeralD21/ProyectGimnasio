package com.example.mstiposuscripcion.service.Impl;

import com.example.mstiposuscripcion.entity.Clasegym;
import com.example.mstiposuscripcion.repository.ClasegymRepository;
import com.example.mstiposuscripcion.service.ClasegymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasegymServiceImpl implements ClasegymService {
    @Autowired
    private ClasegymRepository clasegymRepository;
    @Override
    public List<Clasegym> listar() {
        return clasegymRepository.findAll();
    }

    @Override
    public Clasegym guardar(Clasegym clasegym) {
        return clasegymRepository.save(clasegym);
    }

    @Override
    public Clasegym buscarPorId(Integer id) {
        return clasegymRepository.findById(id).get();
    }

    @Override
    public Clasegym editar(Clasegym categoria) {
        return clasegymRepository.save(categoria);
    }

    @Override
    public void eliminar(Integer id) {
        clasegymRepository.deleteById(id);
    }
}
