package com.ifpb.interfacegrafica.telas;

import javax.swing.*;

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


    }

}
