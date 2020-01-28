package com.ifpb.interfacegrafica.telas;

import com.ifpb.interfacegrafica.enumeration.Titulacao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
        inserirJTextFields(painel);
        inserirJRadioButtons(painel);
        inserirJComboBox(painel);
        inserirJButtons(painel);

    }

    private void inserirJButtons(Container painel) {
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(30, 230, 100,30);
        painel.add(botaoSalvar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(150, 230, 100,30);
        painel.add(botaoCancelar);

        botaoCancelar.addActionListener(e -> {
            System.out.println("Xau");
            System.exit(0);
        });

    }

    private void inserirJComboBox(Container painel) {
        JComboBox campoTitulacao = new JComboBox(Titulacao.values());
        campoTitulacao.setBounds(130,190,250,30);
        painel.add(campoTitulacao);
    }

    private void inserirJRadioButtons(Container painel) {
        JRadioButton botaoMasculino = new JRadioButton("Masculino");
        JRadioButton botaoFeminino = new JRadioButton("Feminino");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(botaoFeminino);
        grupo.add(botaoMasculino);

        botaoMasculino.setSelected(true);

        botaoMasculino.setBounds(130,160,100,30);
        botaoFeminino.setBounds(240, 160, 100, 30);

        painel.add(botaoMasculino);
        painel.add(botaoFeminino);

    }

    private void inserirJTextFields(Container painel) {
        MaskFormatter mascaraCpf = null;
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField campoCpf = new JFormattedTextField();
        campoCpf.setBounds(130,70,250,30);
        if(mascaraCpf!=null)mascaraCpf.install(campoCpf);
        painel.add(campoCpf);

        JTextField campoNome = new JTextField();
        campoNome.setBounds(130,100,250,30);
        painel.add(campoNome);

        MaskFormatter mascaraData = null;
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField campoNascimento = new JFormattedTextField();
        campoNascimento.setBounds(130,130,250,30);
        if(mascaraData!=null) mascaraData.install(campoNascimento);
        painel.add(campoNascimento);

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