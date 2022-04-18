package ex1.views;

import ex1.controller.ClienteController;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeletClient extends JFrame{
    private JComboBox comboBox1;
    private JButton deletarButton;
    private JPanel panel;
    private JButton Cancelar;
    public static DeletClient deletClient;
    ClienteController clienteController = new ClienteController();
    ArrayList<ClienteVO> clients = clienteController.findAllClients();


    public DeletClient(ClienteVO client) throws SQLException {
        setContentPane(panel);
        setSize(400,150);

        try {
            getAllClients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ClienteController clienteController = new ClienteController();
        deletarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteVO clienteVO = (ClienteVO) comboBox1.getSelectedItem();
                try {
                    boolean deleted = clienteController.deletClient(clienteVO);
                    if(deleted){
                        JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso!","DELETAR CLIENTE",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Esse usuário possui um telefone!","DELETAR CLIENTE",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    getAllClients();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }


        });

        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletClient.dispose();
            }
        });
        showScreen(client);
    }

    public void getAllClients() throws SQLException {
        ClienteController clienteController = new ClienteController();
        clients = clienteController.findAllClients();
        int itemCount = comboBox1.getItemCount();

        for(int i = 0; i < itemCount; i++){
            comboBox1.removeItemAt(0);
        }
        clients.forEach((client)->{
            comboBox1.addItem(client);
        });

    }

    public void showScreen(ClienteVO cliente) throws SQLException {
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        if(cliente.getId() > 0){
            for(int c = 0;c<clients.size();c++){
                if(clients.get(c).getId() == cliente.getId()){
                    comboBox1.setSelectedItem(clients.get(c));
                    break;
                }
            }
        }
//        deletClient.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}



