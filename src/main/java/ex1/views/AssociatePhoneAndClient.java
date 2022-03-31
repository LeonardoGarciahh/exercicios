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

    public AssociatePhoneAndClient() throws SQLException {
        setContentPane(panel);
        setSize(300,150);
        ArrayList<ClienteVO> clients = new ArrayList<ClienteVO>();
        ArrayList<PhoneVO> phones = new ArrayList<PhoneVO>();

        ClienteController clienteController = new ClienteController();
        LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
        PhoneController phoneController = new PhoneController();

        clients = clienteController.findAllClients();
        phones = phoneController.findPhoneNotActive();
        for(int c = 0;c<clients.size();c++){
            clienteBox.addItem(clients.get(c).getId()+" - "+clients.get(c).getName());
        }        for(int c = 0;c<phones.size();c++){
            telefoneBox.addItem(phones.get(c).getId()+" - "+phones.get(c).getDdi()+phones.get(c).getDdd()+phones.get(c).getNumber());
        }
        Associar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCliente = Integer.parseInt(clienteBox.getSelectedItem().toString().split("-")[0].trim());
                int idTelefone = Integer.parseInt(telefoneBox.getSelectedItem().toString().split("-")[0].trim());
                LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO(idCliente,idTelefone);
                try {
                    linhaTelefonicaController.associateWithClientAndPhone(linhaTelefonicaVO);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void showScreen() throws SQLException {
        AssociatePhoneAndClient associate = new AssociatePhoneAndClient();
        associate.setResizable(false);
        associate.setLocationRelativeTo(null);
//        telefone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        associate.setVisible(true);

    }
}
