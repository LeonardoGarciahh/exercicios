package ex1.model.bo;

import ex1.model.dao.ClientDAO;
import ex1.model.dao.PhoneDAO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;

public class ClienteBO {

    public ClienteVO addClient(ClienteVO clienteVO) throws SQLException {
        ClientDAO clienteDAO = new ClientDAO();
        return clienteDAO.addClient(clienteVO);
    }
}
