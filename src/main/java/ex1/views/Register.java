package ex1.views;

import ex1.controller.AddressController;
import ex1.controller.ClienteController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Register extends JPanel {
    private JTextField cpfField;
    private JTextField cityField;
    private JPanel mainPanel;
    private JButton registerButton;
    private JTextField nameField;
    private JTextField streetField;
    private JTextField numberField;
    private JTextField stateField;
    private JTextField cepField;
    private JComboBox stateBox;
    public JComboBox addresBox;
    private ArrayList<AddressVO> addressList;


    public Register(ClienteVO client) {
        this.add(mainPanel);
        setSize(600,250);
        List<String> list = new ArrayList<>(Arrays.asList("AC",
                "AL", "AP", "AM", "BA", "CE", "DF",
                "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RR", "SC", "SP", "SE","TO"));
        for(int c = 0;c < list.size();c++){
            stateBox.addItem(list.get(c));
        }
        AddressController addressController = new AddressController();

        try {
            addressList = addressController.findAllAddress();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int c = 0;c<addressList.size();c++){
            addresBox.addItem(addressList.get(c));
        }


        registerButton.addActionListener(e -> {

           if(!cpfField.getText().trim().equals("") && !cityField.getText().trim().equals("") &&
                !nameField.getText().trim().equals("") && !streetField.getText().trim().equals("") &&
                !numberField.getText().trim().equals("") && !stateField.getText().trim().equals("") &&
                !cepField.getText().trim().equals("")) {
               if (cpfField.getText().length() == 11) {


               AddressVO address = new AddressVO(streetField.getText(), Integer.parseInt(numberField.getText()), cepField.getText(), (String) stateBox.getSelectedItem(),
                       cityField.getText(), stateField.getText());

               ClienteController clienteController = new ClienteController();
               try {
                   int id = 0;
                   if(addressList.isEmpty()) {
                        AddressVO addressVO = (AddressVO) addresBox.getSelectedItem();
                        id= addressVO.getId();
                   }
                   address.setId(id);
                   address = addressController.addAdress(address);
                   ClienteVO cliente = new ClienteVO(nameField.getText(), cpfField.getText(), address);
                   if(clienteController.addClient(cliente)){

                       JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
                   }
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

        addresBox.addActionListener(e -> {
            AddressVO addressVO = (AddressVO) addresBox.getSelectedItem();
            assert addressVO != null;
            int id= addressVO.getId();
            try {
                AddressVO address = addressController.findAddress(id);

                streetField.setText(address.getStreet());
                stateField.setText(address.getState());
                cepField.setText(address.getCep());
                numberField.setText(address.getNumber().toString());
                cityField.setText((address.getCity()));
                stateBox.setSelectedItem(address.getUf());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        cpfField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                ClienteController clienteController = new ClienteController();
                try {
                    if(!cpfField.getText().equals("")) {

                        ClienteVO client = clienteController.findClientByCpf(cpfField.getText());
                        if(client.getId() != 0) {
                            nameField.setText(client.getName());
                            for (int c = 0; c < addressList.size(); c++) {
                                if (addressList.get(c).getId() == client.getAdress().getId()) {
                                    addresBox.setSelectedItem(addressList.get(c));
                                }
                            }
                            AddressVO address = client.getAdress();
                            streetField.setText(address.getStreet());
                            stateField.setText(address.getState());
                            cepField.setText(address.getCep());
                            numberField.setText(address.getNumber().toString());
                            cityField.setText((address.getCity()));
                            stateBox.setSelectedItem(address.getUf());
                        }else{
                            clearAddressInput();
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        try {
            showScreen(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showScreen(ClienteVO client) throws SQLException {
        if(client.getId() >0) {
            setClient(client);
        }
        this.setVisible(true);

    }



    public void setClient(ClienteVO client) throws SQLException {
        ClienteController clienteController = new ClienteController();
        client = clienteController.findClient(client.getId());

            cpfField.setText(client.getCpf());
            nameField.setText(client.getName());
            for (int c = 0; c < addressList.size(); c++) {
                if (addressList.get(c).getId() == client.getAdress().getId()) {
                    addresBox.setSelectedItem(addressList.get(c));
                }
            }
            AddressVO address = client.getAdress();
            streetField.setText(address.getStreet());
            stateField.setText(address.getState());
            cepField.setText(address.getCep());
            numberField.setText(address.getNumber().toString());
            cityField.setText((address.getCity()));
            stateBox.setSelectedItem(address.getUf());
        }


    public void clearAddressInput(){
        streetField.setText("");
        cityField.setText("");
        cepField.setText("");
        numberField.setText("");
        stateField.setText("");
        nameField.setText("");
    }


}
