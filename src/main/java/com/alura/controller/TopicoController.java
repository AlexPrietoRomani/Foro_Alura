package com.alura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.model.Topico;
import com.alura.service.impl.TopicoServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {
    
    private final TopicoServiceImpl ser;

    @GetMapping
    public ResponseEntity<List<Topico>> listarTodo() {
        List<Topico> res = ser.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Topico> listar(@PathVariable Long id) {
        Topico res = ser.findById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Topico> add(@RequestBody Topico entity) {
        Topico res = ser.save(entity);
        
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Topico> update(@PathVariable Long id, @RequestBody Topico entity) {
        entity.setId(id);
        Topico res = ser.save(entity);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ser.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
