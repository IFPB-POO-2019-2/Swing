package com.ifpb.interfacegrafica.dao;

import com.ifpb.interfacegrafica.banco.ConFactory;
import com.ifpb.interfacegrafica.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDaoBanco {

    private ConFactory conFactory;

    public UsuarioDaoBanco(){
        conFactory = new ConFactory();
    }

    public boolean salvar(Usuario usuario) throws SQLException,
            ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO usuario(email, nome, nascimento, senha)" +
                    "VALUES (?,?,?,?)");
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getNome());
            pstmt.setDate(3,
                    java.sql.Date.valueOf(usuario.getNascimento()));
            pstmt.setString(4, usuario.getSenha());

            return pstmt.executeUpdate() > 0;
        }

    }

}
