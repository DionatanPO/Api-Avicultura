/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Produtor;
import com.example.api_avicultura.repository.ProdutorRepository;
import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dionatan
 */
@Service
public class ProdutorAuthenticateService {

    private ProdutorRepository produtorRepository;
    private ProdutorService produtorService;
    private TokenService tokenService;

    @Autowired
      public ProdutorAuthenticateService(ProdutorRepository produtorRepository, ProdutorService produtorService, TokenService tokenService) {
        this.produtorRepository = produtorRepository;
        this.produtorService = produtorService;
        this.tokenService = tokenService;
    }

    public Produtor authenticate(Produtor p) {
        Produtor produtor;
        try {
            produtor = produtorService.buscaPorCodiidentificacao(p.getCodidentificacao());
        } catch (Exception e) {
            produtor = new Produtor();
        }

        if (p.getSenha().equals(produtor.getSenha())) {

            String tokenGerado = tokenService.genereteToken();
            produtor.setToken(tokenGerado);
            return produtor;
        } else {
            return produtor;
        }

    }



    private boolean validarToken(String token) {
        try {
            String tokenValidado = token.replace("Bearer", "");
            Claims claims = tokenService.decodeToken(tokenValidado);
            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());
            //verificar se o token esta expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) {
                System.out.println(claims.getExpiration());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Token expirado");
            return false;
        }

    }

}
