package ex1.controller;

import ex1.model.bo.AddressBO;
import ex1.model.bo.ClienteBO;
import ex1.model.bo.PhoneBO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneController {

    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.addPhone(phoneVO);
    }

    public Boolean deletPhone(PhoneVO phoneVO) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.deletPhone(phoneVO);
    }

    public Boolean updatePhone(PhoneVO phoneVO) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.updatePhone(phoneVO);
    }

    public ArrayList<PhoneVO> findAllPhone() throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.findAllPhone();
    }

    public PhoneVO findPhone(Integer id) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.findPhone(id);
    }

    public Boolean checkIfActive(PhoneVO phoneVO) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.checkIfActive(phoneVO);
    }

    public Boolean turnOffPhone(Integer idtelefone) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.turnOffPhone(idtelefone);
    }


}

