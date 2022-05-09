package ex1.views;

import ex1.controller.PhoneController;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Telefone extends JPanel{
    private JTextField ddiField;
    private JPanel panel1;
    private JTextField dddField;
    private JTextField numeroField;
    private JButton cadastrarButton;
    private JComboBox typeBox;

    public Telefone() {
        this.add(panel1);
        typeBox.addItem("Movel");
        typeBox.addItem("Fixo");

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!ddiField.getText().trim().equals("") && !dddField.getText().trim().equals("") &&
                    !numeroField.getText().trim().equals("")){

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

        this.setVisible(true);
    }
}
