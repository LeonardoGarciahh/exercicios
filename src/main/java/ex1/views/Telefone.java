package ex1.views;

import ex1.controller.PhoneController;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Telefone extends JFrame{
    private JTextField ddiField;
    private JPanel panel1;
    private JTextField dddField;
    private JTextField numeroField;
    private JButton cadastrarButton;
    private JComboBox typeBox;

    public Telefone() throws SQLException {
        setContentPane(panel1);
        setSize(500,90);
        typeBox.addItem("Movel");
        typeBox.addItem("Fixo");
//        ArrayList<ClienteVO> clients = new ArrayList<ClienteVO>();
//        ClienteController clienteController = new ClienteController();
//        clients = clienteController.findAllClients();
//        for(int c = 0;c<clients.size();c++){
//            clientesBox.addItem(clients.get(c).getId()+" - "+clients.get(c).getName());
//        }

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!ddiField.getText().trim().equals("") && !dddField.getText().trim().equals("") &&
                    !numeroField.getText().trim().equals("")){
//                    int id = Integer.parseInt(clientesBox.getSelectedItem().toString().split("-")[0].trim());

                    PhoneVO phone = new PhoneVO(numeroField.getText(),Integer.parseInt(dddField.getText()),Integer.parseInt(ddiField.getText()),((typeBox.getSelectedItem() == "Movel")?0:1));
                    PhoneController phoneController = new PhoneController();
                    try {
                        phone = phoneController.addPhone(phone);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
    }
    public static void showScreen() throws SQLException {
        Telefone telefone = new Telefone();
        telefone.setResizable(false);
        telefone.setLocationRelativeTo(null);
//        telefone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        telefone.setVisible(true);

    }
}
