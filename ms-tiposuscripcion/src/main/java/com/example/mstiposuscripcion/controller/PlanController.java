package com.example.mstiposuscripcion.controller;

import com.example.mstiposuscripcion.entity.Plan;
import com.example.mstiposuscripcion.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;
    @GetMapping
    public ResponseEntity<List<Plan>> listar(){
        return ResponseEntity.ok(planService.listar());
    }

    @PostMapping
    public ResponseEntity<Plan> guardar(@RequestBody Plan plan){

        return  ResponseEntity.ok(planService.guardar(plan));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Plan> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(planService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> editar(@PathVariable(required = true)Integer id,@RequestBody Plan plan){
        return ResponseEntity.ok(planService.editar(plan));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        planService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
