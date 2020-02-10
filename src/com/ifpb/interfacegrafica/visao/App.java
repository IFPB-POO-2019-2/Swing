package com.ifpb.interfacegrafica.visao;

import com.ifpb.interfacegrafica.dao.UsuarioDaoArquivo;
import com.ifpb.interfacegrafica.dao.UsuarioDaoBanco;
import com.ifpb.interfacegrafica.modelo.Usuario;
import com.ifpb.interfacegrafica.telas.TelaLogin;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

//        PrimeiraJanela janela = new PrimeiraJanela();
//        janela.setVisible(true);

//        TelaLogin login = new TelaLogin();
//        login.setVisible(true);

        UsuarioDaoBanco daoBanco = new UsuarioDaoBanco();

        try {
//            daoBanco.salvar(new Usuario("joao@gmail.com",
//                    "João",
//                    LocalDate.of(2000,10,10),
//                    "123456"));
            System.out.println(daoBanco.buscarPorEmail("joao2@gmail.com"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
