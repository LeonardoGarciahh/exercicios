package ex1.views;

import ex1.controller.PhoneController;
import ex1.model.selectors.PhoneSelector;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllPhones extends JPanel {
    private JTable table1;
    private JPanel panel1;
    private JTextField textFieldDDD;
    private JTextField textFieldPhone;
    private JButton buscarButton;
    private JComboBox comboBox1;
    PhoneController phoneController = new PhoneController();
    ArrayList<PhoneVO> phones;

    {
        try {
            phones = phoneController.findAllPhone();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ShowAllPhones() {
        this.add(panel1);
        setSize(600,250);

        comboBox1.addItem("Todos");
        comboBox1.addItem("Movel");
        comboBox1.addItem("Fixo");

        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"DDI", "DDD", "NUMERO","TIPO","ATIVO"}, 0);

        table1.setModel(tableModel);

        for (PhoneVO phone: phones) {
            tableModel.addRow(new Object[]{(phone.getDdd()), (phone.getDdd()), (phone.getNumber()),((phone.getType()==0)?"Movel":"Fixo"),(phone.getActive())});
        }
        buscarButton.addActionListener(e -> {

            PhoneSelector phoneSelector = new PhoneSelector((textFieldDDD.getText().equals(""))?-1:Integer.parseInt(textFieldDDD.getText()),
                    textFieldPhone.getText(), getTypePhone(comboBox1.getSelectedItem().toString()));
            try {

                phones = findPhonesBySelector(phoneSelector);
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setRowCount(0);
                table1.setModel(tableModel);
                for (PhoneVO phone: phones) {
                    tableModel.addRow(new Object[]{(phone.getDdd()), (phone.getDdd()), (phone.getNumber()),((phone.getType()==0)?"Movel":"Fixo"),(phone.getActive())});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public ArrayList<PhoneVO> findPhonesBySelector(PhoneSelector phoneSelector) throws SQLException {
        PhoneController phoneController = new PhoneController();
        return phoneController.findPhoneBySelector(phoneSelector);
    }

    public Integer getTypePhone(String type){
        if(type.equals("Movel")){
            return 0;
        }else if(type.equals("Fixo")){
            return 1;
        }
        return -1;
    }

}
