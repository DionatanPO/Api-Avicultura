package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Lote;
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
    OvoService ovoService;

    @PostMapping()
    public ResponseEntity<Ovo> cadastrar(@RequestBody Ovo ovo) {

        Ovo ovoSalvo = ovoService.salvar(ovo);

        return new ResponseEntity<>(ovoSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Ovo> editar(@RequestBody Ovo ovo) {

        Ovo ovoSalvo = ovoService.salvar(ovo);

        return ResponseEntity.ok(ovoSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Ovo ovo = new Ovo();
        ovo.setId(id);
        ovoService.delete(ovo);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Ovo>> mostrarTodos() {

        List ovoList = ovoService.buscarTodos();

        return new ResponseEntity<>(ovoList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Ovo> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ovoService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


   @GetMapping(value = "loteid/")
    @ResponseBody
    public ResponseEntity<List<Lote>> buscaLote(@RequestParam Long lote_id) {
        Lote lote = new Lote();
        lote.setId(lote_id);
        List ovoList = ovoService.buscarLote(lote);

        return new ResponseEntity<>(ovoList, HttpStatus.OK);
    }
}
