package com.ifpb.interfacegrafica.visao;

import com.ifpb.interfacegrafica.enumeration.Titulacao;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        ImageIcon icone = new ImageIcon("imagens/icone.png");

//        JOptionPane.showMessageDialog(null,
//                "Não foi possível acessar",
//                "Mensagem de erro",
//                JOptionPane.PLAIN_MESSAGE,
//                icone);

//        Titulacao resultado = (Titulacao) JOptionPane
//                .showInputDialog(null,
//                        "Qual sua formação",
//                        "Entrada de dados",
//                        JOptionPane.QUESTION_MESSAGE,
//                        icone,
//                        Titulacao.values(),
//                        Titulacao.Graduação);

//        int resultado = JOptionPane.showConfirmDialog(
//                null,
//                "Isso pode apagar dados, deseja continuar?",
//                "Escolha uma opção",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.PLAIN_MESSAGE,
//                icone
//        );

//        switch (resultado){
//            case JOptionPane.YES_OPTION:
//                System.out.println("Respondeu sim");
//                break;
//            case JOptionPane.NO_OPTION:
//                System.out.println("Respondeu não");
//                break;
//            case JOptionPane.CANCEL_OPTION:
//                System.out.println("Cancelou");
//                break;
//            case JOptionPane.CLOSED_OPTION:
//                System.out.println("Fechou");
//                break;
//        }

        int resultado = JOptionPane
                .showOptionDialog(null,
                "Escolha sua titulação",
                "Entrada de dados",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Titulacao.values(),
                Titulacao.Graduação);

        System.out.println(resultado);

    }

}
