package com.ifpb.interfacegrafica.telas;

import com.ifpb.interfacegrafica.dao.UsuarioDaoSet;
import com.ifpb.interfacegrafica.modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TelaLogin extends JFrame {
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton entrarButton;
    private JButton cadastrarButton;
    private JPanel painel;
    private JLabel loginImagem;
    private UsuarioDaoSet usuarioDao;

    public TelaLogin(){
        super("Tela de Login");

        usuarioDao = new UsuarioDaoSet();
        //Apenas enquanto não aprendemos persistência
        usuarioDao.salvar(new Usuario("admin@gmail.com",
                "admin",
                LocalDate.now(),
                "123456"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painel);
        pack();
        cadastrarButton.addActionListener(e -> {
            TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
            cadastroUsuario.setVisible(true);
        });
        entrarButton.addActionListener(e -> {
            Usuario usuario = usuarioDao
                    .buscarPorEmail(campoEmail.getText());

            if(usuario == null){
                JOptionPane.showMessageDialog(this,
                        "Usuário não encontrado");
            }else{
                if(usuario.autenticar(campoEmail.getText(),
                        new String(campoSenha.getPassword()))){
                    JOptionPane.showMessageDialog(this,
                            "Logado");
                }else{
                    JOptionPane.showMessageDialog(this,
                            "Senha incorreta");
                }
            }

        });
    }

    private void createUIComponents() {
        loginImagem = new JLabel();
        ImageIcon icone = new ImageIcon("imagens/login.png");
        loginImagem.setIcon(icone);
    }
}
