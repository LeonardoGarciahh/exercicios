package ex1.model.bo;

import ex1.controller.LinhaTelefonicaController;
import ex1.model.dao.AddressDAO;
import ex1.model.dao.ClientDAO;
import ex1.model.dao.PhoneDAO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteBO {

    public Boolean addClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        ClienteVO client = findClientByCpf(clienteVO.getCpf());

        if(client.getId() == 0) {
            return (clienteDAO.addClient(clienteVO)!=null)?true:false;
        }else{
            clienteVO.setId(client.getId());
            return clienteDAO.updateClient(clienteVO);
        }
    }

    public Boolean deletClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
        ArrayList<LinhaTelefonicaVO> linhaTelefonica = linhaTelefonicaController.findPhoneByClient(clienteVO.getId());
        if(linhaTelefonica.size() == 0) {
            return clienteDAO.deletClient(clienteVO);
        }else{
            return false;
        }
    }

    public Boolean updateClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.updateClient(clienteVO);
    }

    public ClienteVO findClient(int id) {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.findClient(id);
    }

    public ClienteVO findClientByCpf(String cpf) {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.findClientByCpf(cpf);
    }

    public ArrayList<ClienteVO> findAllClients() {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.findAllClients();
    }
}
