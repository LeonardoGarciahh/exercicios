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

        checkActive((PhoneVO) telefoneBox.getSelectedItem());
        Associar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteVO client = (ClienteVO) clienteBox.getSelectedItem();
                PhoneVO telefone = (PhoneVO) telefoneBox.getSelectedItem();
                LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO(client.getId(),telefone.getId());
                try {
                    linhaTelefonicaVO= linhaTelefonicaController.associateWithClientAndPhone(linhaTelefonicaVO);
                    if(linhaTelefonicaVO == null){
                        JOptionPane.showMessageDialog(null,"Erro ao associar "+telefone.getNumber()+" a "+client.getName());
                    }else{
                        JOptionPane.showMessageDialog(null,telefone.getNumber()+" > "+client.getName()+" associados com sucesso!");
                    }
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
                LinhaTelefonicaVO line = null;
                try {
                    line = linhaTelefonicaController.findLine(telefone.getId());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    linhaTelefonicaController.disableLine(line);
                    Boolean turnOff = phoneController.turnOffPhone(telefone.getId());
                    if(!turnOff){
                        JOptionPane.showMessageDialog(null,"Erro ao liberar a linha "+telefone.getNumber());
                    }else{
                        JOptionPane.showMessageDialog(null,"Linha "+telefone.getNumber()+" liberada com sucesso!");
                    }
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
                    checkActive(telefone);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void updateList() throws SQLException {

        clienteBox.removeAllItems();
        telefoneBox.removeAllItems();

        clients = clienteController.findAllClients();
        phones = phoneController.findAllPhone();
        for(int c = 0;c<clients.size();c++){
            clienteBox.addItem(clients.get(c));
        }
        for(int c = 0;c<phones.size();c++){
            telefoneBox.addItem(phones.get(c));
        }
    }
    public void checkActive(PhoneVO telefone) throws SQLException {
        if(phoneController.checkIfActive(telefone)){
            LinhaTelefonicaVO line = linhaTelefonicaController.findLine(telefone.getId());
            for(int c = 0;c<clients.size();c++){
                if(clients.get(c).getId() == line.getIdcliente()){
                    clienteBox.setSelectedItem(clients.get(c));
                    clienteBox.setEnabled(false);
                }
            }
            Associar.setEnabled(false);
            liberarLinhaButton.setEnabled(true);
        }else{
            Associar.setEnabled(true);
            clienteBox.setEnabled(true);
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
