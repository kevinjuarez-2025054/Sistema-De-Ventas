package com.kevinjuarez.Sistema_Venta.Service;

import com.kevinjuarez.Sistema_Venta.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuario();
    Usuario getById(Integer id);
    Usuario registrar(String username, String password,String email);
    Usuario login(String username, String password);
    Usuario saveUsuario(Usuario usuario) throws RuntimeException;
    Usuario updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}
