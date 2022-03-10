package ex1.model.bo;

import ex1.model.dao.AddressDAO;
import ex1.model.vo.AddressVO;

import java.sql.SQLException;

public class AddressBO {
    public AddressVO addAdress(AddressVO adressvo) throws SQLException {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.addAdress(adressvo);
    }

    public Boolean deletAdress(AddressVO adressvo) throws SQLException {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.deletAdress(adressvo);
    }

    public Boolean updateAddress(AddressVO adressvo) throws SQLException {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.updateAddress(adressvo);
    }

}
