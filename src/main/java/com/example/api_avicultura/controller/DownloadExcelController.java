/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api_avicultura.exporter.ExcelFileExporter;
import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Ovo;
import com.example.api_avicultura.model.Pesagem;
import com.example.api_avicultura.model.Produtor;
import com.example.api_avicultura.model.Vacina;
import com.example.api_avicultura.service.LoteService;
import com.example.api_avicultura.service.OvoService;
import com.example.api_avicultura.service.PesagemService;
import com.example.api_avicultura.service.VacinaService;
import java.sql.Array;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dionatan
 */
@RestController
@RequestMapping(value = "/exporter/")
public class DownloadExcelController {

    @Autowired
    LoteService loteService;

    @Autowired
    PesagemService pesagemService;
    
    @Autowired
    OvoService ovoService;

        @Autowired
    VacinaService vacinaService;
//    	@RequestMapping("/")
//    public String index() {
//        return "index";
//    }
    @GetMapping("/download/{id}")
    public void downloadCsv(@PathVariable Long id, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Relatório.xlsx");
        Lote lote = new Lote();
        Produtor produtor = new Produtor();
        produtor.setId(id);

        List<Lote> lotes = new ArrayList<>();

        List<List<Pesagem>> pesagens = new ArrayList<>();
        List<List<Ovo>> ovos = new ArrayList<>();
        List<List<Vacina>> vacinas = new ArrayList<>();

        lote.setProdutor(produtor);

        try {
            lotes = loteService.buscarLoteProdutor(lote);

            for (int i = 0; i < lotes.size(); i++) {
                pesagens.add(pesagemService.buscarLote(lotes.get(i)));
                ovos.add(ovoService.buscarLote(lotes.get(i)));
                vacinas.add(vacinaService.buscarLote(lotes.get(i)));
            }

            for (int i = 0; i < pesagens.size(); i++) {
                for (int c = 0; c < pesagens.get(i).size(); c++) {

                    System.out.println(c);
                }
            }

        } catch (Exception e) {

        }

        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(lotes, pesagens, ovos, vacinas);
        IOUtils.copy(stream, response.getOutputStream());
    }
//
//    private List<Produtor> createTestData() {
//        List<Produtor> customers = new ArrayList<Produtor>();
//        Produtor p = new Produtor();
//        p.setNome("Joao");
//        p.setNome_propriedade("Fazenda");
//        customers.add(p);
//
//        return customers;
//    }
}
