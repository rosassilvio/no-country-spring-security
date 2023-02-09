package com.nocountry.controllers;

import com.nocountry.models.Rol;
import com.nocountry.models.Turno;
import com.nocountry.models.Usuario;
import com.nocountry.models.UsuarioRol;
import com.nocountry.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value="/usuarios/")
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;


    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        return usuarioService.saveUsuario(usuario,usuarioRoles);
    }

    @GetMapping("username/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.getUsuario(username);
    }

    @DeleteMapping("{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.deleteUsuario(usuarioId);
    }

    @GetMapping("{id}")
    public Optional<Usuario> buscarById(@PathVariable Long id) throws EntityNotFoundException {
        return usuarioService.searchById(id);
    }


}
