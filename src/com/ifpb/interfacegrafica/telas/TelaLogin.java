package com.ifpb.interfacegrafica.telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JButton cadastrarButton;
    private JPanel painel;
    private JLabel loginImagem;

    public TelaLogin(){
        super("Tela de Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painel);
        pack();
        cadastrarButton.addActionListener(e -> {
            TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
            cadastroUsuario.setVisible(true);
        });
    }

    private void createUIComponents() {
        loginImagem = new JLabel();
        ImageIcon icone = new ImageIcon("imagens/login.png");
        loginImagem.setIcon(icone);
    }
}
