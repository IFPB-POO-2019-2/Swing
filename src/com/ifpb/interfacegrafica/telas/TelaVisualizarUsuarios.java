package com.ifpb.interfacegrafica.telas;

import com.ifpb.interfacegrafica.dao.UsuarioDao;
import com.ifpb.interfacegrafica.dao.UsuarioDaoBanco;
import com.ifpb.interfacegrafica.modelo.Usuario;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelaVisualizarUsuarios extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private UsuarioDao usuarioDao;
    private List<Usuario> usuarios;

    public TelaVisualizarUsuarios(){
        super("Visualizar Usuários");

        usuarioDao = new UsuarioDaoBanco();

        try {
            usuarios = new ArrayList<>(usuarioDao.getUsuarios());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Falha ao conectar com o banco", "Mensagem de erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Falha ao conectar com o arquivo", "Mensagem de erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        if(usuarios == null) usuarios = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
    }

    private void createUIComponents() {

        TableModel modelo = criarModelo();
        table1 = new JTable(modelo);

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    System.out.println(usuarios.get(table1.getSelectedRow()));
                }
            }
        });

    }

    private TableModel criarModelo() {
        String titulos[] = {"E-mail", "Nome", "Nascimento"};

        TableModel modelo = new TableModel() {
            @Override
            public int getRowCount() {
                return usuarios.size();
            }

            @Override
            public int getColumnCount() {
                return titulos.length;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return titulos[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 2) return LocalDate.class;
                else return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Usuario usuario = usuarios.get(rowIndex);

                switch (columnIndex){
                    case 0: return usuario.getEmail();
                    case 1: return usuario.getNome();
                    case 2: return usuario.getNascimento();
                    default: return "";
                }

            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }

            @Override
            public void addTableModelListener(TableModelListener l) {

            }

            @Override
            public void removeTableModelListener(TableModelListener l) {

            }
        };

        return modelo;

    }
}
