package com.kiara.demo.controller;

import com.kiara.demo.entity.Usuario;
import com.kiara.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/home")
    public String mostrarPagina(){
        return "index.html";
    }

    @PostMapping("/login")
    public String login(String username, String contraseña){
        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario != null && usuario.getContraseña().equals(contraseña)){
            return "redirect:/diario";
        }else {
            return "redirect:/login";
        }
    }

    @GetMapping("/diario")
    public String mostrarDiario(){
        return "diario.html";
    }

}
