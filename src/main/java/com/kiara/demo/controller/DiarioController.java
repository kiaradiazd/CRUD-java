package com.kiara.demo.controller;
import com.kiara.demo.entity.Diario;
import com.kiara.demo.repository.DiarioRepository;
import com.kiara.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DiarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DiarioRepository diarioRepository;

    @PostMapping("/diario")
        public String agregarNota(@ModelAttribute Diario diario){
        diarioRepository.save(diario);
        return "redirect:/diario";
    }

    @GetMapping("/historial")
    public String obtenerNotas(Model model){
        List<Diario> todasLasNotas = diarioRepository.findAll();
        model.addAttribute("notas",todasLasNotas);
        return "/historial";
    }

    @GetMapping("/historial/{id}")
    public String ActualizarNota(@PathVariable Long id, @ModelAttribute Diario nota) {
        Diario diario = diarioRepository.findById(id).orElse(null);
        if (diario != null) {
            diario.setTitulo(nota.getTitulo());
            diario.setContenido(nota.getContenido());
            diarioRepository.save(diario);
        }
        return "redirect:/historial";
    }

    @DeleteMapping("/historial/{id}")
    public String eliminarNota(@PathVariable Long id){
        Diario diario = diarioRepository.findById(id).orElse(null);
        if(diario != null){
            diarioRepository.delete(diario);
        }
        return "redirect:/historial";
    }
}
