package ex1.model.dao;

import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.*;

public class PhoneDAO {
    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO TELEFONE (DDI,DDD,NUMERO,TIPO) VALUES(?,?,?,?)";
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
            System.out.println(phoneVO.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastrar telefone.");
            System.out.println("Erro: " + e.getMessage());
            return null;
        } finally {
            // Banco.closeStatement(stmt);
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);
            System.out.println("Telefone cadastrado cadastrado!");
            return phoneVO;
        }
    }

    public boolean updatePhone(PhoneVO phoneVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE TELEFONE set DDI = '" + phoneVO.getDdi() + "', DDD = '"
                + phoneVO.getDdd()   + "', NUMERO = '" + phoneVO.getNumber()
                + "', TIPO = '" + phoneVO.getType() + "', ATIVO = '" + phoneVO.getActive()+
                "'WHERE IDTELEFONE = " + phoneVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de atualização do telefone.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public boolean deletPhone(PhoneVO phoneVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "DELETE FROM TELEFONE WHERE IDTELEFONE = " + phoneVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que deleta o telefone.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }
}
