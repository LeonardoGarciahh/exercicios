package ex1.views;

import ex1.controller.ClienteController;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class ShowAllClients extends JPanel{
    private JTable table1;
    private JPanel panel1;
    private JButton deleteBtn;
    private JButton editBtn;
    private JButton updateBtn;
    private JButton clienteButton;

    public JButton getEditBtn() {
        return editBtn;
    }

    public Integer getSelectedClient(){
        return (Integer) table1.getValueAt(table1.getSelectedRow(), 0);
    }

    public ShowAllClients() {
        ClienteController clienteController = new ClienteController();
        ArrayList<ClienteVO> clients = null;
        try {
            clients = clienteController.findAllClients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.add(panel1);

        setSize(600,250);
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "CPF"}, 0);
        table1.setDefaultEditor(Object.class, null);
        table1.setModel(tableModel);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableModel.addRow(new Object[]{"ID", "Nome", "CPF"});
        for (ClienteVO cliente: clients) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getName()), (cliente.getCpf())});
        }
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if(table1.getSelectedRow() != -1) {
                    try {
                        if (((Integer) table1.getValueAt(table1.getSelectedRow(), 0)) > 0) {
                            editBtn.setEnabled(true);
                            deleteBtn.setEnabled(true);
                        }
                    }catch(Exception e){
                        deleteBtn.setEnabled(false);
                        editBtn.setEnabled(false);
                    }
                }
            }
        });
//        editBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ClienteVO client = new ClienteVO();
//                try {
//                    client.setId((Integer) table1.getValueAt(table1.getSelectedRow(), 0));
//                    Register register = new Register(client);
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteVO client = new ClienteVO();
                try {
                    client.setId((Integer) table1.getValueAt(table1.getSelectedRow(), 0));

                    DeletClient deletClient = new DeletClient(client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTable();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    ClienteVO client = new ClienteVO();
                    Register register = new Register(client);

            }
        });
    }
    public static void showScreen() {
        ShowAllClients showAllClients = new ShowAllClients();

        showAllClients.setVisible(true);

    }

    public void updateTable() throws SQLException {
        ClienteController clienteController = new ClienteController();
        ArrayList<ClienteVO> clients = clienteController.findAllClients();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "CPF"}, 0);
        table1.setModel(tableModel);
        tableModel.addRow(new Object[]{"ID", "Nome", "CPF"});
        table1.clearSelection();
        deleteBtn.setEnabled(false);
        editBtn.setEnabled(false);


        for (ClienteVO cliente: clients) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getName()), (cliente.getCpf())});
        }
    }
}
