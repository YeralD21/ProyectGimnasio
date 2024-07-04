package com.example.mssuscripcion.service.Impl;

import com.example.mssuscripcion.dto.ClasegymDto;
import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.dto.PlanDto;
import com.example.mssuscripcion.dto.PrecioclaseplanDto;
import com.example.mssuscripcion.entity.Suscripcion;
import com.example.mssuscripcion.feing.ClasegymFeing;
import com.example.mssuscripcion.feing.ClientesusFeing;
import com.example.mssuscripcion.feing.PrecioclaseplanFeing;
import com.example.mssuscripcion.repository.SuscripcionRepository;
import com.example.mssuscripcion.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Autowired
    private ClientesusFeing clientesusFeing;

    @Autowired
    private ClasegymFeing clasegymFeing;

    @Autowired
    private PrecioclaseplanFeing precioclaseplanFeing;

    @Override
    public List<Suscripcion> listar() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion guardar(Suscripcion suscripcion) {
        ClientesusDto clienteDto = clientesusFeing.buscarPorId(suscripcion.getClientegymId()).getBody();
        suscripcion.setClientesusDto(clienteDto);

        PrecioclaseplanDto precioclaseplanDto = precioclaseplanFeing.buscarPorId(suscripcion.getPrecioclaseplanId()).getBody();
        suscripcion.setPrecioclaseplanDto(precioclaseplanDto);

        if (precioclaseplanDto != null) {
            suscripcion.setClasegymDto(precioclaseplanDto.getClasegymDto());
        }

        return suscripcionRepository.save(suscripcion);
    }
    @Override
    public Suscripcion buscarPorId(Integer id) {
        Suscripcion suscripcion = suscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));

        // Obtener datos del cliente
        ClientesusDto clienteDto = clientesusFeing.buscarPorId(suscripcion.getClientegymId()).getBody();
        suscripcion.setClientesusDto(clienteDto);

        // Obtener datos de PrecioClasePlan
        PrecioclaseplanDto precioclaseplanDto = precioclaseplanFeing.buscarPorId(suscripcion.getPrecioclaseplanId()).getBody();
        suscripcion.setPrecioclaseplanDto(precioclaseplanDto);

        // Obtener y asignar ClasegymDto desde PrecioClasePlanDto
        if (precioclaseplanDto != null) {
            ClasegymDto clasegymDto = precioclaseplanDto.getClasegymDto();
            suscripcion.setClasegymDto(clasegymDto);
        }

        return suscripcion;
    }

    @Override
    public Suscripcion editar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public void eliminar(Integer id) {
        suscripcionRepository.deleteById(id);
    }
}
