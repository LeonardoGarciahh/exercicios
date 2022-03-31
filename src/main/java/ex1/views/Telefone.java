package ex1.views;

import ex1.controller.ClienteController;
import ex1.controller.LinhaTelefonicaController;
import ex1.controller.PhoneController;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Telefone extends JFrame{
    private JTextField ddiField;
    private JPanel panel1;
    private JTextField dddField;
    private JTextField numeroField;
    private JTextField tipoField;
    private JButton cadastrarButton;
    private JComboBox clientesBox;
    private JTextField idclienteField;

    public Telefone() throws SQLException {
        setContentPane(panel1);
        setSize(500,150);
        ArrayList<ClienteVO> clients = new ArrayList<ClienteVO>();
        ClienteController clienteController = new ClienteController();
        clients = clienteController.findAllClients();
        for(int c = 0;c<clients.size();c++){
            clientesBox.addItem(clients.get(c).getId()+" - "+clients.get(c).getName());
        }

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!ddiField.getText().trim().equals("") && !dddField.getText().trim().equals("") &&
                    !numeroField.getText().trim().equals("") && !tipoField.getText().trim().equals("") ){
                    int id = Integer.parseInt(clientesBox.getSelectedItem().toString().split("-")[0].trim());

                    PhoneVO phone = new PhoneVO(numeroField.getText(),Integer.parseInt(dddField.getText()),Integer.parseInt(ddiField.getText()),Integer.parseInt(tipoField.getText()));
                    PhoneController phoneController = new PhoneController();
                    LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
                    try {
                        phone = phoneController.addPhone(phone);
                        LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO(id,phone.getId());
                        linhaTelefonicaController.associateWithClientAndPhone(linhaTelefonicaVO);
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
