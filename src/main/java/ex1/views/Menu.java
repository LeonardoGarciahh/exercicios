package ex1.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame{
    private JButton clienteButton;
    private JButton telefoneButton;
    private JButton deletarClienteButton;
    private JPanel panel;
    private JButton associarTelefoneAoClienteButton;
    private JButton allClientsBtn;
    private JButton allPhonesBtn;
    public static Menu menuFrame;

    public Menu() {
        setContentPane(panel);
        setSize(400,150);


        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Register.showScreen();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        telefoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Telefone.showScreen();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        deletarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DeletClient.showScreen();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        associarTelefoneAoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AssociatePhoneAndClient.showScreen();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        allClientsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ShowAllClients.showScreen();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        allPhonesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ShowAllPhones.showScreen();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void showScreen() throws SQLException {
        menuFrame = new Menu();
        menuFrame.setResizable(false);

        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


