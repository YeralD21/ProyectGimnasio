package com.example.mssuscripcion.feing;

import com.example.mssuscripcion.dto.ClasegymDto;
import com.example.mssuscripcion.entity.Suscripcion;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clasegym-service", path = "/clasegym")
public interface ClasegymFeing {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "clasegymListarPorIdCB", fallbackMethod = "fallbackClasegymPorId")
    public ResponseEntity<ClasegymDto> buscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<ClasegymDto> fallbackClasegymPorId(Integer id, Exception e) {
        return ResponseEntity.ok(new ClasegymDto());
    }
}

