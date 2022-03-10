package ex1.model.bo;

import ex1.model.dao.AddressDAO;
import ex1.model.dao.PhoneDAO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;

public class PhoneBO {

    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.addPhone(phoneVO);
    }

    public Boolean deletPhone(PhoneVO phoneVO) throws SQLException {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.deletPhone(phoneVO);
    }

    public Boolean updatePhone(PhoneVO phoneVO) throws SQLException {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.updatePhone(phoneVO);
    }

}
