package com.example.mstiposuscripcion.controller;

import com.example.mstiposuscripcion.entity.Precioclaseplan;
import com.example.mstiposuscripcion.service.PrecioclaseplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/precioclaseplan")
public class PrecioclaseplanController {
    @Autowired
    private PrecioclaseplanService precioclaseplanService;
    @GetMapping
    public ResponseEntity<List<Precioclaseplan>> listar(){
        return ResponseEntity.ok(precioclaseplanService.listar());
    }

    @PostMapping
    public ResponseEntity<Precioclaseplan> guardar(@RequestBody Precioclaseplan precioclaseplan){

        return  ResponseEntity.ok(precioclaseplanService.guardar(precioclaseplan));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Precioclaseplan> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(precioclaseplanService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Precioclaseplan> editar(@PathVariable(required = true)Integer id,@RequestBody Precioclaseplan precioclaseplan){
        return ResponseEntity.ok(precioclaseplanService.editar(precioclaseplan));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        precioclaseplanService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
