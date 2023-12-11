package com.example.estudanteDemo.controllers;

import com.example.estudanteDemo.modelos.Estudante;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EstudanteController {

    @Value("${paises}")
    private List<String> countries;

    @Value("${linguagens}")
    private List<String> linguagens;

    @GetMapping("/showEstudanteForm")
    public String showEstudant (Model model) {

        Estudante estudante = new Estudante();

        model.addAttribute("estudante", estudante);

        model.addAttribute("paises", countries);

        model.addAttribute("linguagens", linguagens);

        return "estudante-form";
    }

    @PostMapping("/processEstudanteForm")
    public String processEstudante(@ModelAttribute("estudante") Estudante estudante) {

        System.out.println("estudante " + estudante.getFirstName() + " " + estudante.getLastName());

        return "estudante-confirmacao";
    }
}
