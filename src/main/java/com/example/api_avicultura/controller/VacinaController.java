package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Vacina;
import com.example.api_avicultura.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vacina/")
public class VacinaController {

    @Autowired
    VacinaService vacinaService;

    @PostMapping()
    public ResponseEntity<Vacina> cadastrar(@RequestBody Vacina vacina) {

        Vacina vacinaSalvo = vacinaService.salvar(vacina);

        return new ResponseEntity<>(vacinaSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Vacina> editar(@RequestBody Vacina vacina) {

        Vacina vacinaSalvo = vacinaService.salvar(vacina);

        return ResponseEntity.ok(vacinaSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Vacina vacina = new Vacina();
        vacina.setId(id);
        vacinaService.delete(vacina);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Vacina>> mostrarTodos() {

        List vacinaList = vacinaService.buscarTodos();

        return new ResponseEntity<>(vacinaList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Vacina> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(vacinaService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


   @GetMapping(value = "loteid/")
    @ResponseBody
    public ResponseEntity<List<Lote>> buscaLote(@RequestParam Long lote_id) {
        Lote lote = new Lote();
        lote.setId(lote_id);
        List vacinaList = vacinaService.buscarLote(lote);

        return new ResponseEntity<>(vacinaList, HttpStatus.OK);
    }
}
