package ex1.views;

import ex1.controller.ClienteController;
import ex1.controller.PhoneController;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllPhones extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton button1;
    PhoneController phoneController = new PhoneController();
    ArrayList<PhoneVO> phones = phoneController.findAllPhone();
    public ShowAllPhones() throws SQLException {
        setContentPane(panel1);
        setSize(600,250);
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"DDI", "DDD", "NUMERO","TIPO","ATIVO"}, 0);
        table1.setModel(tableModel);
        tableModel.addRow(new Object[]{"DDI", "DDD", "NUMERO","TIPO","ATIVO",});
        for (PhoneVO phone: phones) {
            tableModel.addRow(new Object[]{(phone.getDdd()), (phone.getDdd()), (phone.getNumber()),((phone.getType()==0)?"Movel":"Fixo"),(phone.getActive())});
        }

//        table1.setEnabled(false);
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Integer phoneIndex = table1.getSelectionModel().getAnchorSelectionIndex();
//                PhoneController phoneController = new PhoneController();
//                try {
//                    phoneController.deletPhone(phones.get(phoneIndex));
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
    }
    public static void showScreen() throws SQLException {
        ShowAllPhones showAllPhones = new ShowAllPhones();
        showAllPhones.setResizable(false);

        showAllPhones.setLocationRelativeTo(null);
        showAllPhones.setVisible(true);

    }
}
