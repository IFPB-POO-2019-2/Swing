package com.ifpb.interfacegrafica.telas;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Arrays;

public class TelaCadastroUsuario extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField campoNascimento;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton salvarButton;
    private JPanel painel;

    public TelaCadastroUsuario(){
        super("Cadastro de usuário");
        setContentPane(painel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        salvarButton.addActionListener(e -> {
            if(!Arrays.equals(passwordField1.getPassword(),
                    passwordField2.getPassword())){
                JOptionPane.showMessageDialog(this,
                        "As senhas devem ser iguais");
            }else{

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
