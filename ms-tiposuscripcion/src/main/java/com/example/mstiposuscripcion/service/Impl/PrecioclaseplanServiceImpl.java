package com.example.mstiposuscripcion.service.Impl;

import com.example.mstiposuscripcion.entity.Precioclaseplan;
import com.example.mstiposuscripcion.repository.PrecioclaseplanRepository;
import com.example.mstiposuscripcion.service.PrecioclaseplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PrecioclaseplanServiceImpl implements PrecioclaseplanService {
    @Autowired
    private PrecioclaseplanRepository precioclaseplanRepository;
    @Override
    public List<Precioclaseplan> listar() {
        return precioclaseplanRepository.findAll();
    }

    @Override
    public Precioclaseplan guardar(Precioclaseplan precioclaseplan) {
        return precioclaseplanRepository.save(precioclaseplan);
    }

    @Override
    public Precioclaseplan buscarPorId(Integer id) {
        return precioclaseplanRepository.findById(id).get();
    }

    @Override
    public Precioclaseplan editar(Precioclaseplan precioclaseplan) {
        return precioclaseplanRepository.save(precioclaseplan);
    }

    @Override
    public void eliminar(Integer id) {
        precioclaseplanRepository.deleteById(id);
    }
}
