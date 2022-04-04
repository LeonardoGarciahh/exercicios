package ex1.model.bo;

import ex1.model.dao.ClientDAO;
import ex1.model.dao.LinhaTelefonicaDAO;
import ex1.model.dao.PhoneDAO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LinhaTelefonicaBO {

    public LinhaTelefonicaVO associateWithClientAndPhone(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.associateWithClientAndPhone(linhaTelefonicaVO);
    }

    public Boolean deletLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.deletLine(linhaTelefonicaVO);
    }

    public Boolean updateClient(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.updateLine(linhaTelefonicaVO);
    }

    public ArrayList<PhoneVO> findPhoneByClient(Integer idcliente) {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.findPhoneByClient(idcliente);
    }

    public boolean disableLine(LinhaTelefonicaVO linhaTelefonicaVO) {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.disableLine(linhaTelefonicaVO);
    }

    public LinhaTelefonicaVO findLine(Integer idtelefone) {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.findLine(idtelefone);
    }

    public Boolean turnActive(Integer idPhone) {
        LinhaTelefonicaDAO linhaTelefonicaDAO = new LinhaTelefonicaDAO();
        return linhaTelefonicaDAO.turnActive(idPhone);
    }
}
