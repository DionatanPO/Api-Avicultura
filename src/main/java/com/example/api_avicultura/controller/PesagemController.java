package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lote/")
public class LoteController {

    @Autowired
    LoteService loteService;

    @PostMapping()
    public ResponseEntity<Lote> cadastrar(@RequestBody Lote lote) {

        Lote loteSalvo = loteService.salvar(lote);

        return new ResponseEntity<>(loteSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Lote> editar(@RequestBody Lote lote) {

        Lote loteSalvo = loteService.salvar(lote);

        return ResponseEntity.ok(loteSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Lote lote = new Lote();
        lote.setId(id);
        loteService.delete(lote);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Lote>> mostrarTodos() {

        List loteList = loteService.buscarTodos();

        return new ResponseEntity<>(loteList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Lote> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(loteService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
