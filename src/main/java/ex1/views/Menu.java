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
    private JPanel panel;
    public static Menu menuFrame;


    public Menu() {
        setSize(700,300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Menu");
        menuBar.add(mnNewMenu);

        JMenuItem menuItemTelefone = new JMenuItem("Telefone");
        mnNewMenu.add(menuItemTelefone);

        JMenuItem menuItemRegister = new JMenuItem("Registrar");
        mnNewMenu.add(menuItemRegister);

        JMenuItem menuItemListAllClients = new JMenuItem("Listar todos clientes");
        mnNewMenu.add(menuItemListAllClients);

        JMenuItem menuItemListAllPhones = new JMenuItem("Listar todos telefones");
        mnNewMenu.add(menuItemListAllPhones);

        JMenuItem menuItemAssociatePhone = new JMenuItem("Associar telefone");
        mnNewMenu.add(menuItemAssociatePhone);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);

        menuItemTelefone.addActionListener(e -> {
            Telefone telefone = new Telefone();
            setContentPane(telefone);
            revalidate();
        });

        menuItemRegister.addActionListener(e -> {
            Register register = null;

            ClienteVO clienteVO = new ClienteVO();
            register = new Register(clienteVO);

            setContentPane(register);
            revalidate();
        });

        menuItemAssociatePhone.addActionListener(e -> {
            AssociatePhoneAndClient associatePhoneAndClient = new AssociatePhoneAndClient();
            setContentPane(associatePhoneAndClient);
            revalidate();
        });

        menuItemListAllPhones.addActionListener(e -> {
            ShowAllPhones showAllPhones = new ShowAllPhones();
            setContentPane(showAllPhones);
            revalidate();
        });

        menuItemListAllClients.addActionListener(e -> {
                final ShowAllClients showAllClients = new ShowAllClients();
                showAllClients.getEditBtn().addActionListener(e1 -> {

                    ClienteVO client = new ClienteVO();
                    client.setId(showAllClients.getSelectedClient());
                    Register register = new Register(client);
                    setContentPane(register);
                    revalidate();
                });

                showAllClients.getClienteButton().addActionListener(e1 -> {

                    ClienteVO client = new ClienteVO();

                    Register register = new Register(client);
                    setContentPane(register);
                    revalidate();
                });
            setContentPane(showAllClients);
            revalidate();
        });

    }

    public static void showScreen()  {
        menuFrame = new Menu();
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }


}


