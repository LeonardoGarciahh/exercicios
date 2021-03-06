package ex1.controller;

import com.mysql.cj.xdevapi.Client;
import ex1.model.bo.AddressBO;
import ex1.model.bo.ClienteBO;
import ex1.model.exception.ClientePossuiLinhaTelefonicaException;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteController {

    public Boolean addClient(ClienteVO clientVO) throws SQLException {
        ClienteBO clienteBO = new ClienteBO();
        return clienteBO.addClient(clientVO);
    }

    public Boolean deletClient(ClienteVO clientVO) throws SQLException {
        ClienteBO clienteBO = new ClienteBO();
        return clienteBO.deletClient(clientVO);
    }

    public Boolean updateClient(ClienteVO clientVO) throws SQLException {
        ClienteBO clienteBO = new ClienteBO();
        return clienteBO.updateClient(clientVO);
    }

    public ClienteVO findClient(int id) throws SQLException {
        ClienteBO clienteBO = new ClienteBO();
        return clienteBO.findClient(id);
    }

    public ClienteVO findClientByCpf(String cpf) throws SQLException {
        ClienteBO clienteBO = new ClienteBO();
        return clienteBO.findClientByCpf(cpf);
    }

    public ArrayList<ClienteVO> findAllClients() throws SQLException {
        ClienteBO clienteBO = new ClienteBO();
        return clienteBO.findAllClients();
    }
}
