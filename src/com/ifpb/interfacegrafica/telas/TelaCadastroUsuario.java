package com.ifpb.interfacegrafica.telas;

import com.ifpb.interfacegrafica.dao.UsuarioDaoSet;
import com.ifpb.interfacegrafica.modelo.Usuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TelaCadastroUsuario extends JFrame {
    private JTextField campoEmail;
    private JTextField campoNome;
    private JFormattedTextField campoNascimento;
    private JPasswordField campoSenha1;
    private JPasswordField campoSenha2;
    private JButton salvarButton;
    private JPanel painel;
    private UsuarioDaoSet usuarioDao;
    private DateTimeFormatter formatter;

    public TelaCadastroUsuario(){
        super("Cadastro de usuário");

        usuarioDao = new UsuarioDaoSet();

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        setContentPane(painel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        salvarButton.addActionListener(e -> {
            //TODO validar os campos
            if(!Arrays.equals(campoSenha1.getPassword(),
                    campoSenha2.getPassword())){
                JOptionPane.showMessageDialog(this,
                        "As senhas devem ser iguais");
            }else{
                String email = campoEmail.getText();
                String nome = campoNome.getText();
                //TODO Tratar as exceções
                LocalDate nascimento = LocalDate
                        .parse(campoNascimento.getText(), formatter);
                String senha = new String(campoSenha1.getPassword());

                Usuario usuario = new Usuario(email, nome, nascimento, senha);
                if(usuarioDao.salvar(usuario)){
                    JOptionPane.showMessageDialog(this,
                            "Salvo com sucesso");
                }else{
                    JOptionPane.showMessageDialog(this,
                            "Usuário já cadastrado",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private void createUIComponents() {
        MaskFormatter formatter = null;
        try {
             formatter = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        campoNascimento = new JFormattedTextField();
        if(formatter!= null) formatter.install(campoNascimento);

    }
}
