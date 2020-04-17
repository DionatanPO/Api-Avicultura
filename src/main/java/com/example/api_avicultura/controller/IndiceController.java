package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Indice;
import com.example.api_avicultura.service.IndiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/indice/")
public class IndiceController {

    @Autowired
    IndiceService proprietarioService;

    @PostMapping()
    public ResponseEntity<Indice> cadastrar(@RequestBody Indice proprietario) {

        Indice proprietarioSalvo = proprietarioService.salvar(proprietario);

        return new ResponseEntity<>(proprietarioSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Indice> editar(@RequestBody Indice proprietario) {

        Indice proprietarioSalvo = proprietarioService.salvar(proprietario);

        return ResponseEntity.ok(proprietarioSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Indice proprietario = new Indice();
        proprietario.setId(id);
        proprietarioService.delete(proprietario);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Indice>> mostrarTodos() {

        List proprietarioList = proprietarioService.buscarTodos();

        return new ResponseEntity<>(proprietarioList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Indice> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(proprietarioService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
