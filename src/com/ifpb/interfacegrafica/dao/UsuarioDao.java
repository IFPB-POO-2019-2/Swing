package com.ifpb.interfacegrafica.dao;

import com.ifpb.interfacegrafica.modelo.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public interface UsuarioDao {

    boolean salvar(Usuario usuario) throws SQLException,
            ClassNotFoundException, IOException;
    Usuario buscarPorEmail(String email) throws SQLException,
            ClassNotFoundException, IOException;
    Set<Usuario> getUsuarios() throws SQLException,
            ClassNotFoundException, IOException;

}