package com.example.api_avicultura.controller;

import com.example.api_avicultura.model.Produtor;
import com.example.api_avicultura.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtor/")
public class ProdutorController {

    @Autowired
    ProdutorService proprietarioService;

    @PostMapping()
    public ResponseEntity<Produtor> cadastrar(@RequestBody Produtor proprietario) {

        Produtor proprietarioSalvo = proprietarioService.salvar(proprietario);

        return new ResponseEntity<>(proprietarioSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Produtor> editar(@RequestBody Produtor proprietario) {

        Produtor proprietarioSalvo = proprietarioService.salvar(proprietario);

        return ResponseEntity.ok(proprietarioSalvo);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletar(@PathVariable Long id) {

        Produtor proprietario = new Produtor();
        proprietario.setId(id);
        proprietarioService.delete(proprietario);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "todos")
    public ResponseEntity<List<Produtor>> mostrarTodos() {

        List proprietarioList = proprietarioService.buscarTodos();

        return new ResponseEntity<>(proprietarioList, HttpStatus.OK);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<Produtor> buscaPorID(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(proprietarioService.buscaPorID(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

 @GetMapping(value = "validar/")
    @ResponseBody
    public ResponseEntity<List<Produtor>> buscaNome(@RequestParam String nome, String codigoIdentificacao) {
        Produtor produtor = new Produtor();
        produtor.setNome(nome);
        produtor.setCod_identificacao(codigoIdentificacao);
        List produtorList = proprietarioService.buscarvalidacao(produtor);

        return new ResponseEntity<List<Produtor>>(produtorList, HttpStatus.OK);
    }

}
