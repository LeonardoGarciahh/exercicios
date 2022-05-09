package ex1.views;

import ex1.model.vo.ClienteVO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame{

    private JPanel contentPane;
    private JButton telefoneButton;
    private JPanel panel;
    private JButton associarTelefoneAoClienteButton;
    private JButton allClientsBtn;
    private JButton allPhonesBtn;
    public static Menu menuFrame;


    public Menu() {
        setSize(1000,300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("New menu");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Telefone");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
        mnNewMenu.add(mntmNewMenuItem_1);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);

        mntmNewMenuItem.addActionListener(e -> {
            Telefone telefone = new Telefone();
            setContentPane(telefone);
            revalidate();
        });

        telefoneButton.addActionListener(e -> {

        });

        associarTelefoneAoClienteButton.addActionListener(e -> {
            try {
                AssociatePhoneAndClient.showScreen();

            } catch (Exception ex) {
                ex.printStackTrace();
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
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }


}


