package ex1.controller;

import ex1.model.bo.ClienteBO;
import ex1.model.bo.LinhaTelefonicaBO;
import ex1.model.bo.PhoneBO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LinhaTelefonicaController {

    public LinhaTelefonicaVO associateWithClientAndPhone(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();
        return linhaTelefonicaBO.associateWithClientAndPhone(linhaTelefonicaVO);
    }

    public Boolean deletLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();
        return linhaTelefonicaBO.deletLine(linhaTelefonicaVO);
    }

    public Boolean updateLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();
        return linhaTelefonicaBO.updateClient(linhaTelefonicaVO);
    }

    public ArrayList<PhoneVO> findPhoneByClient(Integer idcliente) throws SQLException {
        LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();
        return linhaTelefonicaBO.findPhoneByClient(idcliente);
    }

    public boolean disableLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaBO linhaTelefonicaBO = new LinhaTelefonicaBO();
        return linhaTelefonicaBO.disableLine(linhaTelefonicaVO);
    }

}
