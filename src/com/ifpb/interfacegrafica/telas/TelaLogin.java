package com.ifpb.interfacegrafica.telas;

import com.ifpb.interfacegrafica.dao.UsuarioDao;
import com.ifpb.interfacegrafica.dao.UsuarioDaoArquivo;
import com.ifpb.interfacegrafica.dao.UsuarioDaoBanco;
import com.ifpb.interfacegrafica.dao.UsuarioDaoSet;
import com.ifpb.interfacegrafica.modelo.Usuario;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class TelaLogin extends JFrame {
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton entrarButton;
    private JButton cadastrarButton;
    private JPanel painel;
    private JLabel loginImagem;
    private UsuarioDao usuarioDao;

    public TelaLogin(){
        super("Tela de Login");

        usuarioDao = new UsuarioDaoBanco();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painel);
        pack();

        cadastrarButton.addActionListener(e -> {
            TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
            cadastroUsuario.setVisible(true);
        });
        entrarButton.addActionListener(e -> {

            Usuario usuario = null;
            try {
                usuario = usuarioDao
                        .buscarPorEmail(campoEmail.getText());
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,
                        "Falha na conexão com o arquivo",
                        "Mensagem de erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Falha na conexão com o banco",
                        "Mensagem de erro",
                        JOptionPane.ERROR_MESSAGE);
            }

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
