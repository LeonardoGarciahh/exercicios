package ex1.model.bo;

import ex1.model.dao.AddressDAO;
import ex1.model.vo.AddressVO;

import java.sql.SQLException;

public class AddressBO {
    public Boolean addAdress(AddressVO adressvo) throws SQLException {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.addAdress(adressvo);
    }

}
