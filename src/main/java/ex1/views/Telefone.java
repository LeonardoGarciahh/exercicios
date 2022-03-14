package ex1.views;

import ex1.controller.LinhaTelefonicaController;
import ex1.controller.PhoneController;
import ex1.model.vo.LinhaTelefonicaVO;
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
    private JTextField tipoField;
    private JButton cadastrarButton;
    private JTextField idclienteField;

    public Telefone() {
        setContentPane(panel1);
        setSize(500,200);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!ddiField.getText().trim().equals("") && !dddField.getText().trim().equals("") &&
                    !numeroField.getText().trim().equals("") && !tipoField.getText().trim().equals("") &&
                    !idclienteField.getText().trim().equals("") ){

                    PhoneVO phone = new PhoneVO(numeroField.getText(),Integer.parseInt(dddField.getText()),Integer.parseInt(ddiField.getText()),Integer.parseInt(tipoField.getText()));
                    PhoneController phoneController = new PhoneController();
                    LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
                    try {
                        phone = phoneController.addPhone(phone);
                        LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO(Integer.parseInt(idclienteField.getText()),phone.getId());
                        linhaTelefonicaController.associateWithClientAndPhone(linhaTelefonicaVO);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
    }
    public static void showScreen(){
        Telefone telefone = new Telefone();
        telefone.setLocationRelativeTo(null);
        telefone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        telefone.setVisible(true);

    }
}
