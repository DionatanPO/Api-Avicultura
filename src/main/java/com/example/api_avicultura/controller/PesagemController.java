package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Pesagem;
import com.example.api_avicultura.service.PesagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pesagem/")
public class PesagemController {

    @Autowired
    PesagemService pesagemService;

    @PostMapping()
    public ResponseEntity<Pesagem> cadastrar(@RequestBody Pesagem pesagem) {

        Pesagem pesagemSalvo = pesagemService.salvar(pesagem);

        return new ResponseEntity<>(pesagemSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Pesagem> editar(@RequestBody Pesagem pesagem) {

        Pesagem pesagemSalvo = pesagemService.salvar(pesagem);

        return ResponseEntity.ok(pesagemSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Pesagem pesagem = new Pesagem();
        pesagem.setId(id);
        pesagemService.delete(pesagem);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Pesagem>> mostrarTodos() {

        List pesagemList = pesagemService.buscarTodos();

        return new ResponseEntity<>(pesagemList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Pesagem> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(pesagemService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
   @GetMapping(value = "loteid/")
    @ResponseBody
    public ResponseEntity<List<Lote>> buscaLote(@PathVariable Long id) {
        Lote lote = new Lote();
        lote.setId(id);
        List pesagemList = pesagemService.buscarLote(lote);

        return new ResponseEntity<>(pesagemList, HttpStatus.OK);
    }

}
