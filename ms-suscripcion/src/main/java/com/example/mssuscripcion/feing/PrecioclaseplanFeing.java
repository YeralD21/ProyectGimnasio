package com.example.mssuscripcion.feing;

import com.example.mssuscripcion.dto.ClientesusDto;
import com.example.mssuscripcion.dto.PrecioclaseplanDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-precioclaseplan-service", path = "/precioclaseplan")

public interface PrecioclaseplanFeing {
    @GetMapping ( "/{id}" )
    @CircuitBreaker(name = "precioclaseplanListarPorIdCB", fallbackMethod = "fallbackPrecioclaseplanPorId")
    public ResponseEntity<PrecioclaseplanDto> buscarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<PrecioclaseplanDto> fallbackPrecioclaseplanPorId(Integer id, Exception e) {
        return ResponseEntity.ok(new PrecioclaseplanDto());
    }
}
