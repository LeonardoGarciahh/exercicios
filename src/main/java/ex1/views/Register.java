package ex1.views;

import ex1.controller.AddressController;
import ex1.controller.ClienteController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register extends JFrame {
    private JTextField cpfField;
    private JTextField cidadeField;
    private JPanel mainPanel;
    private JButton cadastrarButton;
    private JTextField nameField;
    private JTextField ruaField;
    private JTextField numeroField;
    private JTextField estadoField;
    private JTextField cepField;
    private JTextField ufField;

    public Register() {
        setContentPane(mainPanel);
        setSize(500,200);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!cpfField.getText().trim().equals("") && !cidadeField.getText().trim().equals("") &&
                    !nameField.getText().trim().equals("") && !ruaField.getText().trim().equals("") &&
                    !numeroField.getText().trim().equals("") && !estadoField.getText().trim().equals("") &&
                    !cepField.getText().trim().equals("") && !ufField.getText().trim().equals("")){

                    AddressVO address = new AddressVO(ruaField.getText(),Integer.parseInt(numeroField.getText()),cepField.getText(),ufField.getText(),
                            cidadeField.getText(),estadoField.getText());

                    AddressController addressController = new AddressController();
                    ClienteController clienteController = new ClienteController();
                    try {
                        address = addressController.addAdress(address);
                        ClienteVO client = new ClienteVO(nameField.getText(),cpfField.getText(),address);
                        clienteController.addClient(client);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                }else{
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");

                }
            }
        });
    }

    public static void showScreen(){
        Register register = new Register();
        register.setLocationRelativeTo(null);
        register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        register.setVisible(true);

    }
}
