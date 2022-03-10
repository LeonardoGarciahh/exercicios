package ex1.model.bo;

import ex1.model.dao.LinhaTelefonicaDAO;
import ex1.model.dao.PhoneDAO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;

public class LinhaTelefonicaBO {

    public LinhaTelefonicaVO associateWithClientAndPhone(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.associateWithClientAndPhone(linhaTelefonicaVO);
    }

}
