package com.ifpb.interfacegrafica.telas;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class PrimeiraJanela extends JFrame {

    public PrimeiraJanela(){
        super("Meu primeiro formulário");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);

        ImageIcon icone = new ImageIcon("imagens/icone.png");
        setIconImage(icone.getImage());

//        setAlwaysOnTop(true);
//        setTitle("Novo título");
        setResizable(false);

        Container painel = getContentPane();
        painel.setLayout(null);
        painel.setBackground(Color.white);

        inserirJLabels(painel);

    }

    private void inserirJLabels(Container painel) {
        JLabel labelTitulo = new JLabel(
                "Cadastro de Professor");

        labelTitulo.setBounds(20,20,380,30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
            new Font("Arial", Font.BOLD, 16));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
//        labelTitulo.setToolTipText("Exemplo");
        painel.add(labelTitulo);

        Font fonteLabels = new Font("Arial", Font.BOLD, 14);

        JLabel labelCpf = new JLabel("CPF");
        labelCpf.setBounds(20, 70, 100, 30);
        labelCpf.setFont(fonteLabels);
        painel.add(labelCpf);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20, 100, 100, 30);
        labelNome.setFont(fonteLabels);
        painel.add(labelNome);

        JLabel labelNascimento = new JLabel("Nascimento");
        labelNascimento.setBounds(20, 130, 100, 30);
        labelNascimento.setFont(fonteLabels);
        painel.add(labelNascimento);

        JLabel labelSexo = new JLabel("Sexo");
        labelSexo.setBounds(20, 160, 100, 30);
        labelSexo.setFont(fonteLabels);
        painel.add(labelSexo);

        JLabel labelTitulacao = new JLabel("Titulação");
        labelTitulacao.setBounds(20, 190, 100, 30);
        labelTitulacao.setFont(fonteLabels);
        painel.add(labelTitulacao);

    }

}
