package com.br.fiap.mslogistica.controller;

import com.br.fiap.mslogistica.model.Entregador;
import com.br.fiap.mslogistica.service.EntregadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/entregador")
public class EntregadorController {
    private EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    @GetMapping
    public List<Entregador> getAllEntregador() {
        return entregadorService.getAllEntregador();
    }

    @GetMapping ("/{entregadorId}")
    public ResponseEntity<?> findByIdEntregador (@PathVariable Integer entregadorId){
        return entregadorService.findByIdEntregador(entregadorId);
    }
    @PostMapping
    public Entregador saveEntregador(@RequestBody Entregador entregador){
        return entregadorService.saveEntregador(entregador);
    }

/*    @PutMapping("/{entregadorId}")
    public Entregador updateEntregador(@PathVariable Integer entregadorId, @RequestBody Entregador alteraEntregador){
        return entregadorService.updateEntregador(entregadorId, alteraEntregador);
    }*/

    @DeleteMapping("/{entregadorId}")
    public ResponseEntity<?> deleteEntregador(@PathVariable Integer entregadorId){
        return entregadorService.deleteEntregador(entregadorId);
    }
}
