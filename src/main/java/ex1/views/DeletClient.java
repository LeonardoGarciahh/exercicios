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


    public DeletClient() throws SQLException {
        setContentPane(panel);
        setSize(400,150);

        getAllClients();
        ClienteController clienteController = new ClienteController();
        deletarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(comboBox1.getSelectedItem().toString().split("-")[0].trim());
                ClienteVO clienteVO = new ClienteVO();
                clienteVO.setId(id);
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

    }

    public void getAllClients() throws SQLException {
        ClienteController clienteController = new ClienteController();
        ArrayList<ClienteVO> clients = clienteController.findAllClients();
        int itemCount = comboBox1.getItemCount();

        for(int i = 0; i < itemCount; i++){
            comboBox1.removeItemAt(0);
        }
        clients.forEach((client)->{
            comboBox1.addItem(client.getId()+" - "+client.getName());
        });

    }

    public static void showScreen() throws SQLException {
        deletClient = new DeletClient();
        deletClient.setResizable(false);

        deletClient.setLocationRelativeTo(null);
//        deletClient.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        deletClient.setVisible(true);
    }
}



