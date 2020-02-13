package com.ifpb.interfacegrafica.visao;

import com.ifpb.interfacegrafica.telas.TelaLogin;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

//        PrimeiraJanela janela = new PrimeiraJanela();
//        janela.setVisible(true);

        TelaLogin login = new TelaLogin();
        login.setVisible(true);

//        JFileChooser chooser = new JFileChooser();
//        chooser.setDialogTitle("Escolha um arquivo");
//        chooser.setApproveButtonText("Salvar aqui");
//        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        chooser.setMultiSelectionEnabled(true);
//        switch (chooser.showOpenDialog(null )){
//            case JFileChooser.APPROVE_OPTION:
//                System.out.println(Arrays.toString(chooser.getSelectedFiles()));
//                break;
//            case JFileChooser.CANCEL_OPTION:
//                System.out.println("Cancelou");
//                break;
//        }

//        try(BufferedReader reader = new BufferedReader(
//                new FileReader("configuracoes.txt"))){
//
//            reader.lines().forEach(l -> System.out.println(l));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try(BufferedWriter writer = new BufferedWriter(
//                new PrintWriter(
//                        new FileWriter("configuracoes.txt", false),
//                        true))) {
//
//            writer.write("Teste");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}
