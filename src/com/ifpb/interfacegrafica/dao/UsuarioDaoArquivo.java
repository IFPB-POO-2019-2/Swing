package com.ifpb.interfacegrafica.dao;

import com.ifpb.interfacegrafica.modelo.Usuario;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDaoArquivo implements UsuarioDao{

    private File arquivo;

    public UsuarioDaoArquivo() throws IOException {
        arquivo = new File("usuarios");

        if(!arquivo.exists()) arquivo.createNewFile();
    }

    @Override
    public Set<Usuario> getUsuarios() throws IOException,
            ClassNotFoundException {
        if(arquivo.length()>0){
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo)
            );
            return (HashSet<Usuario>) in.readObject();
        }else return new HashSet<>();
    }

    @Override
    public Usuario buscarPorEmail(String email) throws IOException,
            ClassNotFoundException {
        return getUsuarios().stream().filter(
                u -> u.getEmail().equals(email)
        ).findFirst().orElse(null);
    }

    @Override
    public boolean salvar(Usuario usuario) throws IOException,
            ClassNotFoundException {
        Set<Usuario> usuarios = getUsuarios();
        return usuarios.add(usuario) && atualizarArquivo(usuarios);
    }

    private boolean atualizarArquivo(Set<Usuario> usuarios) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(arquivo)
        );
        out.writeObject(usuarios);
        return true;
    }

    //TODO Criar método de atualizar e remover

}
