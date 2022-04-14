package ex1.views;

import ex1.controller.ClienteController;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;


public class ShowAllClients extends JFrame{
    private JTable table1;
    private JPanel panel1;
    ClienteController clienteController = new ClienteController();
    ArrayList<ClienteVO> clients = clienteController.findAllClients();
    public ShowAllClients() throws SQLException {

        setContentPane(panel1);
        setSize(600,250);
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "CPF"}, 0);
        table1.setModel(tableModel);
        tableModel.addRow(new Object[]{"ID", "Nome", "CPF"});
        for (ClienteVO cliente: clients) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getName()), (cliente.getCpf())});
        }

        table1.setEnabled(false);
    }
    public static void showScreen() throws SQLException {
        ShowAllClients showAllClients = new ShowAllClients();
        showAllClients.setResizable(false);

        showAllClients.setLocationRelativeTo(null);
        showAllClients.setVisible(true);

    }
}
