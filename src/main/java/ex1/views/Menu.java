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
    }

    public static void showScreen() throws SQLException {
        menuFrame = new Menu();
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }
}


