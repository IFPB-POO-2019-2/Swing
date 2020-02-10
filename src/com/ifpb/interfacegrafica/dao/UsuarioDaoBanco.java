package com.ifpb.interfacegrafica.dao;

import com.ifpb.interfacegrafica.banco.ConFactory;
import com.ifpb.interfacegrafica.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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

    public Usuario buscarPorEmail(String email) throws SQLException,
            ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?");
            pstm.setString(1, email);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                String nome = rs.getString("nome");
                LocalDate nascimento = rs
                        .getDate("nascimento").toLocalDate();
                String senha = rs.getString("senha");
                return new Usuario(email, nome, nascimento, senha);
            }
            return null;
        }
    }

}
