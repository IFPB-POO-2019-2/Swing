package com.ifpb.interfacegrafica.dao;

import com.ifpb.interfacegrafica.modelo.Usuario;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDaoArquivo {

    private File arquivo;

    public UsuarioDaoArquivo() throws IOException {
        arquivo = new File("usuarios");

        if(!arquivo.exists()) arquivo.createNewFile();
    }

    public Set<Usuario> getUsuarios() throws IOException,
            ClassNotFoundException {
        if(arquivo.length()>0){
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo)
            );
            return (HashSet<Usuario>) in.readObject();
        }else return new HashSet<>();
    }

    public Usuario buscarPorEmail(String email) throws IOException,
            ClassNotFoundException {
        return getUsuarios().stream().filter(
                u -> u.getEmail().equals(email)
        ).findFirst().orElse(null);
    }

}
