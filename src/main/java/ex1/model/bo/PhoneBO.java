package ex1.model.bo;

import ex1.model.dao.PhoneDAO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public PhoneVO findPhone(Integer id) throws SQLException {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.findPhone(id);
    }

    public Boolean checkIfActive(PhoneVO phoneVO) {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.checkIfActive(phoneVO);
    }

    public ArrayList<PhoneVO> findAllPhone() {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.findAllPhone();
    }

    public Boolean turnOffPhone(Integer idtelefone) {
        PhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.turnOffPhone(idtelefone);
    }
}
