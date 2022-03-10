package ex1.model.dao;

import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import java.sql.*;

public class LinhaTelefonicaDAO {

    public LinhaTelefonicaVO associateWithClientAndPhone(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO LINHA_TELEFONICA (DT_ATIVACAO,DT_DESATIVACAO,IDCLIENTE,IDTELEFONE) VALUES(now(),null,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatementWithPK(conn, query);
        pstm.setInt(1, linhaTelefonicaVO.getIdcliente());
        pstm.setInt(2, linhaTelefonicaVO.getIdtelefone());


        try {
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            linhaTelefonicaVO.setId(id);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastrar linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
            return null;
        } finally {
            // Banco.closeStatement(stmt);
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);
            System.out.println("Linha telefonica cadastrado cadastrado!");
            return linhaTelefonicaVO;
        }
    }

    public boolean updateLine(LinhaTelefonicaVO linhaTelefonicaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE LINHA_TELEFONICA set DT_ATIVACAO = '" + linhaTelefonicaVO.getDt_Ativacao() + "', DT_DESATIVACAO = '"
                + linhaTelefonicaVO.getDt_Desativacao() + "', IDCLIENTE = '" + linhaTelefonicaVO.getIdcliente() +
                "', IDTELEFONE = '" + linhaTelefonicaVO.getIdtelefone() +
                "'WHERE IDLINHATELEFONICA = " + linhaTelefonicaVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de atualização da linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public boolean deletLine(LinhaTelefonicaVO linhaTelefonicaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "DELETE FROM LINHA_TELEFONICA WHERE IDLINHATELEFONICA = " + linhaTelefonicaVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que deleta a linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

}
