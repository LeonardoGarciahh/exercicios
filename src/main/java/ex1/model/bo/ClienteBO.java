package ex1.model.bo;

import ex1.controller.LinhaTelefonicaController;
import ex1.model.dao.AddressDAO;
import ex1.model.dao.ClientDAO;
import ex1.model.dao.PhoneDAO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteBO {

    public ClienteVO addClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        if(!findClientByCpf(clienteVO.getCpf())) {
            return clienteDAO.addClient(clienteVO);
        }else{
            JOptionPane.showMessageDialog(null,"CPF ja existente!");
        }
        return clienteVO;
    }

    public Boolean deletClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
        ArrayList<PhoneVO> phones = linhaTelefonicaController.findPhoneByClient(clienteVO.getId());
        if(phones.size() == 0) {
            return clienteDAO.deletClient(clienteVO);
        }else{
            JOptionPane.showMessageDialog(null,"Esse usuário possui um telefone!","DELETAR CLIENTE",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public Boolean updateClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.updateClient(clienteVO);
    }

    public ClienteVO findClient(int id) {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.findClient(id);
    }

    public Boolean findClientByCpf(String cpf) {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.findClientByCpf(cpf);
    }

    public ArrayList<ClienteVO> findAllClients() {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.findAllClients();
    }
}
