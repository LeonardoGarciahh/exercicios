package ex1.controller;

import ex1.model.bo.AddressBO;
import ex1.model.bo.PhoneBO;
import ex1.model.vo.AddressVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;

public class PhoneController {

    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        PhoneBO phoneBO = new PhoneBO();
        return phoneBO.addPhone(phoneVO);
    }

}
