package ex1.views;

import ex1.controller.ClienteController;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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

    public JButton getClienteButton() {
        return clienteButton;
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

                            editBtn.setEnabled(true);
                            deleteBtn.setEnabled(true);

                    }catch(Exception e){
                        deleteBtn.setEnabled(false);
                        editBtn.setEnabled(false);
                    }
                }
            }
        });

        deleteBtn.addActionListener(e -> {
            ClienteVO client = new ClienteVO();
            try {
                client.setId((Integer) table1.getValueAt(table1.getSelectedRow(), 0));

                DeletClient deletClient = new DeletClient(client);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        updateBtn.addActionListener(e -> {
            try {
                updateTable();
            } catch (SQLException ex) {
                ex.printStackTrace();
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
        table1.clearSelection();
        deleteBtn.setEnabled(false);
        editBtn.setEnabled(false);


        for (ClienteVO cliente: clients) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getName()), (cliente.getCpf())});
        }
    }
}
