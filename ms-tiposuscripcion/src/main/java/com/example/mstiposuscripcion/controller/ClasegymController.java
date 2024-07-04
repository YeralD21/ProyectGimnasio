package com.example.mstiposuscripcion.controller;

import com.example.mstiposuscripcion.entity.Clasegym;
import com.example.mstiposuscripcion.service.ClasegymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clasegym")
public class ClasegymController {
    @Autowired
    private ClasegymService clasegymService;
    @GetMapping
    public ResponseEntity<List<Clasegym>> listar(){
        return ResponseEntity.ok(clasegymService.listar());
    }

    @PostMapping
    public ResponseEntity<Clasegym> guardar(@RequestBody Clasegym categoria){

        return  ResponseEntity.ok(clasegymService.guardar(categoria));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Clasegym> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(clasegymService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Clasegym> editar(@PathVariable(required = true)Integer id,@RequestBody Clasegym clasegym){
        return ResponseEntity.ok(clasegymService.editar(clasegym));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        clasegymService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
