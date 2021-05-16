package com.api.vacinacao.controllers;

import com.api.vacinacao.models.Usuario;
import com.api.vacinacao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity registraUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
        try {
            usuarioService.getRepo().save(usuario);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            if(result.hasErrors()) {
                return ResponseEntity.badRequest().body(result.getAllErrors().get(0).getDefaultMessage());
            } else {
                return ResponseEntity.badRequest().body("Erro ao cadastrar usuário, favor verificar os dados.");
            }
        }
    }

    @GetMapping("/listar")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getRepo().findAll();
        return usuarios;
    }
}
