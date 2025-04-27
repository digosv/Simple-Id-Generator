package com.example.shortid.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ShortIdController
{
    // Instanciando os characteres que iremos utilizar no id
    private final static String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIKJLMNOPQRSTUVWXYZ0123456789-_";
    // Biblioteca de Numero Aleatório
    private final Random random = new Random();

    // Rota de Get
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/generate")
    public String generateShortId(@RequestParam(defaultValue = "6") int size){
        StringBuilder id = new StringBuilder();
        for(int i = 0; i < size; i++){
            int index = random.nextInt(CHARACTERS.length());
            // Desta forma a concatenação entra em loop, a idea ta recomendando alterar para o StringBuilder
            //id += CHARACTERS.charAt(index);
            // Utilizando o StringBuilder para fazer a concatenação
            id.append(CHARACTERS.charAt(index));

        }
        return id.toString();
    }
}
