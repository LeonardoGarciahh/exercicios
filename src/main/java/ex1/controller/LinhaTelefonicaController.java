package ex1.controller;

import ex1.model.bo.LinhaTelefonicaBO;
import ex1.model.bo.PhoneBO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;

public class LinhaTelefonicaController {

    public LinhaTelefonicaVO associateWithClientAndPhone(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();
        return linhaTelefonicaBO.associateWithClientAndPhone(linhaTelefonicaVO);
    }

}
