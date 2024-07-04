package com.example.mssuscripcion.feing;

import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.entity.Suscripcion;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")

public interface ClientesusFeing {
    @GetMapping( "/{id}" )
    @CircuitBreaker(name = "clientesusListarPorIdCB", fallbackMethod = "fallbackClientesusPorId")
    public ResponseEntity<ClientesusDto> buscarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<ClientesusDto> fallbackClientesusPorId(Integer id, Exception e) {
        return ResponseEntity.ok(new ClientesusDto());
    }
}
