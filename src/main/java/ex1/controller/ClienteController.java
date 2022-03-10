package ex1.controller;

import ex1.model.bo.AddressBO;
import ex1.model.bo.ClienteBO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;

import java.sql.SQLException;

public class ClienteController {

    public ClienteVO addClient(ClienteVO clientVO) throws SQLException {
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
}
