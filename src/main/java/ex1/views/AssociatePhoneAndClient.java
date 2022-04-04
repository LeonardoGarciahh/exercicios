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

public class AssociatePhoneAndClient extends JFrame{
    private JPanel panel;
    private JComboBox clienteBox;
    private JComboBox telefoneBox;
    private JButton Associar;
    private JButton liberarLinhaButton;
    ArrayList<ClienteVO> clients = new ArrayList<ClienteVO>();
    ArrayList<PhoneVO> phones = new ArrayList<PhoneVO>();
    ClienteController clienteController = new ClienteController();
    LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
    PhoneController phoneController = new PhoneController();

    public AssociatePhoneAndClient() throws SQLException {
        setContentPane(panel);
        setSize(300,150);
        updateList();
        System.out.println(telefoneBox.getSelectedItem());
        checkActive((PhoneVO) telefoneBox.getSelectedItem());

        System.out.println(phones);
        for(int c = 0;c<clients.size();c++){
            clienteBox.addItem(clients.get(c));
        }        for(int c = 0;c<phones.size();c++){
            telefoneBox.addItem(phones.get(c));
        }
        Associar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteVO client = (ClienteVO) clienteBox.getSelectedItem();
                PhoneVO telefone = (PhoneVO) telefoneBox.getSelectedItem();
                LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO(client.getId(),telefone.getId());
                try {
                    linhaTelefonicaController.associateWithClientAndPhone(linhaTelefonicaVO);
                    updateList();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        liberarLinhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteVO client = (ClienteVO) clienteBox.getSelectedItem();
                PhoneVO telefone = (PhoneVO) telefoneBox.getSelectedItem();
                LinhaTelefonicaVO line = linhaTelefonicaController.findLine(telefone.getId());
                try {
                    linhaTelefonicaController.disableLine(line);
                    phoneController.turnOffPhone(telefone.getId());
                    updateList();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        telefoneBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhoneVO telefone = (PhoneVO) telefoneBox.getSelectedItem();
                try {
                    System.out.println(phoneController.checkIfActive(telefone));
                    if(phoneController.checkIfActive(telefone)){
                        Associar.setEnabled(false);
                        liberarLinhaButton.setEnabled(true);
                    }else{
                        Associar.setEnabled(true);
                        liberarLinhaButton.setEnabled(false);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void updateList() throws SQLException {
        clients = clienteController.findAllClients();
        phones = phoneController.findAllPhone();
    }
    public void checkActive(PhoneVO telefone) throws SQLException {
        if(phoneController.checkIfActive(telefone)){
            Associar.setEnabled(false);
            liberarLinhaButton.setEnabled(true);
        }else{
            Associar.setEnabled(true);
            liberarLinhaButton.setEnabled(false);
        }
    }
    public static void showScreen() throws SQLException {
        AssociatePhoneAndClient associate = new AssociatePhoneAndClient();
        associate.setResizable(false);
        associate.setLocationRelativeTo(null);
//        telefone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        associate.setVisible(true);

    }
}
