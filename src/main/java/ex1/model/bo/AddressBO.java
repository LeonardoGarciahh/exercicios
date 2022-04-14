package ex1.model.bo;

import ex1.model.dao.AddressDAO;
import ex1.model.vo.AddressVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class AddressBO {
    public AddressVO addAdress(AddressVO adressvo) throws SQLException {
        AddressDAO adressDAO = new AddressDAO();
        AddressVO adressActual = findAddress(adressvo.getId());
        if(Objects.equals(adressActual.getNumber(), adressvo.getNumber()) && adressActual.getUf().equals(adressvo.getUf()) &&
        adressActual.getState().equals(adressvo.getState()) && adressActual.getCep().equals(adressvo.getCep()) &&
        adressActual.getStreet().equals(adressvo.getStreet()) && adressActual.getCity().equals(adressvo.getCity())
        ){
            return adressActual;
        }else {
            return adressDAO.addAdress(adressvo);
        }
    }

    public Boolean deletAdress(AddressVO adressvo) {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.deletAdress(adressvo);
    }

    public Boolean updateAddress(AddressVO adressvo) {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.updateAddress(adressvo);
    }

    public AddressVO findAddress(int id) {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.findAddress(id);
    }

    public ArrayList<AddressVO> findAllAddress() {
        AddressDAO adressDAO = new AddressDAO();
        return adressDAO.findAllAddress();
    }
}
