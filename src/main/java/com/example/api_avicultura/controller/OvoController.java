package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Ovo;
import com.example.api_avicultura.service.OvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ovo/")
public class OvoController {

    @Autowired
    OvoService proprietarioService;

    @PostMapping()
    public ResponseEntity<Ovo> cadastrar(@RequestBody Ovo proprietario) {

        Ovo proprietarioSalvo = proprietarioService.salvar(proprietario);

        return new ResponseEntity<>(proprietarioSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Ovo> editar(@RequestBody Ovo proprietario) {

        Ovo proprietarioSalvo = proprietarioService.salvar(proprietario);

        return ResponseEntity.ok(proprietarioSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Ovo proprietario = new Ovo();
        proprietario.setId(id);
        proprietarioService.delete(proprietario);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Ovo>> mostrarTodos() {

        List proprietarioList = proprietarioService.buscarTodos();

        return new ResponseEntity<>(proprietarioList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Ovo> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(proprietarioService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
