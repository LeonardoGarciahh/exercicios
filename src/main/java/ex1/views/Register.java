package ex1.views;

import ex1.controller.AddressController;
import ex1.controller.ClienteController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public Register() throws SQLException {
        setContentPane(mainPanel);
        setSize(600,250);
        List<String> list = new ArrayList<>(Arrays.asList("AC",
                "AL",
                "AP",
                "AM",
                "BA",
                "CE",
                "DF",
                "ES",
                "GO",
                "MA",
                "MT",
                "MS",
                "MG",
                "PA",
                "PB",
                "PR",
                "PE",
                "PI",
                "RJ",
                "RN",
                "RS",
                "RO",
                "RR",
                "SC",
                "SP",
                "SE",
                "TO"));
        for(int c = 0;c < list.size();c++){
            comboBox1.addItem(list.get(c));
        }
                AddressController addressController = new AddressController();
        ArrayList<AddressVO> addressList = new ArrayList<AddressVO>();
        addressList = addressController.findAllAddress();
        for(int c = 0;c<addressList.size();c++){
            comboBox2.addItem(addressList.get(c));
        }

        cadastrarButton.addActionListener(e -> {

           if(!cpfField.getText().trim().equals("") && !cidadeField.getText().trim().equals("") &&
                !nameField.getText().trim().equals("") && !ruaField.getText().trim().equals("") &&
                !numeroField.getText().trim().equals("") && !estadoField.getText().trim().equals("") &&
                !cepField.getText().trim().equals("")) {
               if (cpfField.getText().length() == 11) {


               AddressVO address = new AddressVO(ruaField.getText(), Integer.parseInt(numeroField.getText()), cepField.getText(), (String) comboBox1.getSelectedItem(),
                       cidadeField.getText(), estadoField.getText());

               ClienteController clienteController = new ClienteController();
               try {
                   address = addressController.addAdress(address);
                   ClienteVO client = new ClienteVO(nameField.getText(), cpfField.getText(), address);
                   clienteController.addClient(client);
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }


           }else {
                   JOptionPane.showMessageDialog(null, "Tamanho do cpf é de 11 digitos!");
           }
            }else{
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");

            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox2.getSelectedItem().toString().split(",")[0].replace("id: ",""));
                int id = Integer.parseInt(comboBox2.getSelectedItem().toString().split(",")[0].replace("id: ",""));
                try {
                    AddressVO address = addressController.findAddress(id);
                    ruaField.setText(address.getStreet());
                    estadoField.setText(address.getState());
                    cepField.setText(address.getCep());
                    numeroField.setText(address.getNumero().toString());
                    cidadeField.setText((address.getCidade()));
                    comboBox1.setSelectedItem(address.getUf());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void showScreen() throws SQLException {
        Register register = new Register();
        register.setResizable(false);

        register.setLocationRelativeTo(null);
//        register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        register.setVisible(true);

    }
}
