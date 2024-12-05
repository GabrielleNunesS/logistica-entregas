package com.br.fiap.mslogistica.service;

import com.br.fiap.mslogistica.model.Entregador;
import com.br.fiap.mslogistica.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository entregadorRepository;

    public EntregadorService(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public List<Entregador> getAllEntregador() {
        return entregadorRepository.findAll();
    }

    public Entregador saveEntregador(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public ResponseEntity<?> findByIdEntregador (Integer entregadorId){
        Entregador entregador = entregadorRepository.findById(entregadorId).orElse(null);

        if (entregador != null){
            return ResponseEntity.ok(entregador);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }
    }

/*    public Entregador updateEntregador (Integer entregadorId, Entregador alteraEntregador){
        Entregador entregadorExiste = entregadorRepository.findById(entregadorId).orElse(null);

        if(entregadorExiste != null){
            entregadorExiste.setNome(alteraEntregador.getNome());
            entregadorExiste.setCpf(alteraEntregador.getCpf());
            entregadorExiste.setTelefone(alteraEntregador.getTelefone());

            return entregadorRepository.save(entregadorExiste);
        } else{
            throw new NoSuchElementException("Entregador não encontrado");
        }
    }*/

    public ResponseEntity<?> deleteEntregador(Integer entregadorId) {
        Entregador entregadorExiste = entregadorRepository.findById(entregadorId).orElse(null);

        if (entregadorExiste != null) {
            entregadorRepository.delete(entregadorExiste);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Entregador excluido com sucesso!");
        } else {
            throw new NoSuchElementException("Entregador não encontrado");
        }
    }
}
