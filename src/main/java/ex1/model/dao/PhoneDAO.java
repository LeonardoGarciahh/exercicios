package ex1.model.dao;

import ex1.model.selectors.PhoneSelector;
import ex1.model.vo.PhoneVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneDAO {
    Logger logger = Logger.getLogger(AddressDAO.class.getName());
    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        Connection conn = Banco.getConnection();
        String query = "INSERT INTO TELEFONE (DDI,DDD,NUMERO,TIPO,ATIVO) VALUES(?,?,?,?,False)";
        PreparedStatement pstm = Banco.getPreparedStatementWithPK(conn, query);
        pstm.setInt(1, phoneVO.getDdi());
        pstm.setInt(2, phoneVO.getDdd());
        pstm.setString(3, phoneVO.getNumber());
        pstm.setInt(4, phoneVO.getType());

        try {
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            phoneVO.setId(id);
        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query de cadastrar telefone.");
            logger.log(Level.INFO, e.getMessage());
            return null;
        } finally {
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);

        }
        return phoneVO;
    }

    public boolean updatePhone(PhoneVO phoneVO) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE TELEFONE set DDI = ?, DDD = ?, NUMERO = ?, TIPO = ?, ATIVO = ? WHERE IDTELEFONE = ?";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);

        pstm.setInt(1, phoneVO.getDdi());
        pstm.setInt(2, phoneVO.getDdd());
        pstm.setString(3, phoneVO.getNumber());
        pstm.setInt(4, phoneVO.getType());
        pstm.setBoolean(5, phoneVO.getActive());
        pstm.setInt(6, phoneVO.getId());
        try {
            if (pstm.executeUpdate() == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query de atualiza????o telefone.");
            logger.log(Level.INFO, e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public boolean deletPhone(PhoneVO phoneVO) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "DELETE FROM TELEFONE WHERE IDTELEFONE = ?";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setInt(1, phoneVO.getId());
        try {
            if (pstm.executeUpdate()== 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query de deletar o telefone.");
            logger.log(Level.INFO, e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public PhoneVO findPhone(Integer id) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        PhoneVO phoneVO = new PhoneVO();

            query = "SELECT * FROM TELEFONE WHERE IDTELEFONE = ?";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setInt(1, id);


        try {
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                phoneVO.setId(resultado.getInt(1));
                phoneVO.setDdi(resultado.getInt(2));
                phoneVO.setDdd(resultado.getInt(3));
                phoneVO.setNumber(resultado.getString(4));
                phoneVO.setType(resultado.getInt(5));
                phoneVO.setActive(resultado.getBoolean(6));
            }

        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query que busca os telefone.");
            logger.log(Level.INFO, e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return phoneVO;
    }

    public Boolean checkIfActive(PhoneVO phoneVO){
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;


        Boolean resp = false;
        if(phoneVO != null) {
            query = "SELECT * FROM TELEFONE WHERE IDTELEFONE = " + phoneVO.getId();

            try {
                resultado = stmt.executeQuery(query);
                if (resultado.next()) {

                    if (resultado.getBoolean(6)) {
                        resp = true;
                    }

                }

            } catch (SQLException e) {
                logger.log(Level.INFO, "Erro ao executar que verifica se o telefone est?? ativo.");
                logger.log(Level.INFO, e.getMessage());
            } finally {
                Banco.closeResultSet(resultado);
                Banco.closeStatement(stmt);
                Banco.closeConnection(conn);
            }
        }
        return resp;
    }

    public ArrayList<PhoneVO> findAllPhone() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<PhoneVO> phoneVOlist = new ArrayList<PhoneVO>();

        query = "SELECT * FROM TELEFONE";


        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                PhoneVO phoneVO = new PhoneVO();
                phoneVO.setId(resultado.getInt(1));
                phoneVO.setDdi(resultado.getInt(2));
                phoneVO.setDdd(resultado.getInt(3));
                phoneVO.setNumber(resultado.getString(4));
                phoneVO.setType(resultado.getInt(5));
                phoneVO.setActive(resultado.getBoolean(6));
                phoneVOlist.add(phoneVO);
            }

        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query que busca todos os telefones.");
            logger.log(Level.INFO, e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return phoneVOlist;
    }
    public boolean turnOffPhone(Integer idPhone){
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE TELEFONE set ATIVO = False where idtelefone="+idPhone;
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query de ativa????o da linha telefonica.");
            logger.log(Level.INFO, e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public ArrayList<PhoneVO> findPhoneBySelector(PhoneSelector phoneSelector) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<PhoneVO> phoneVOlist = new ArrayList<PhoneVO>();
        query = "SELECT * FROM TELEFONE";
        System.out.println(phoneSelector.temFiltro());
        if (phoneSelector.temFiltro()) {
            query = criarFiltros(phoneSelector, query);
        }


        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                PhoneVO phoneVO = new PhoneVO();
                phoneVO.setId(resultado.getInt(1));
                phoneVO.setDdi(resultado.getInt(2));
                phoneVO.setDdd(resultado.getInt(3));
                phoneVO.setNumber(resultado.getString(4));
                phoneVO.setType(resultado.getInt(5));
                phoneVO.setActive(resultado.getBoolean(6));
                phoneVOlist.add(phoneVO);
            }

        } catch (SQLException e) {
            logger.log(Level.INFO, "Erro ao executar a query que busca os telefones por selector.");
            logger.log(Level.INFO, e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return phoneVOlist;
    }

    public String criarFiltros(PhoneSelector selector, String sql){
        sql += " WHERE ";
        boolean primeiro = true;

        if(selector.getDdd() >0){
            if (!primeiro) {
                sql += " AND ";
            }
            sql += "ddd = " + selector.getDdd();
            primeiro = false;
        }

        if(!selector.getTelefone().equals("") && selector.getTelefone().trim().length() >0){
            if (!primeiro) {
                sql += " AND ";
            }
            sql += "numero = " + selector.getTelefone();
            primeiro = false;
        }
        if(selector.getType() == 0 || selector.getType() == 1){
            if (!primeiro) {
                sql += " AND ";
            }
            sql += "tipo = " + selector.getType();
            primeiro = false;
        }
        System.out.println(sql);
        return sql;
    }
}
