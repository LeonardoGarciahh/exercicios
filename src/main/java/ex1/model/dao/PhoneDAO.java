package ex1.model.dao;

import ex1.model.vo.AddressVO;
import ex1.model.vo.PhoneVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDAO {
    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO TELEFONE (DDI,DDD,NUMERO,TIPO,ATIVO) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatementWithPK(conn, query);
        pstm.setInt(1, phoneVO.getDdi());
        pstm.setInt(2, phoneVO.getDdd());
        pstm.setString(3, phoneVO.getNumber());
        pstm.setInt(4, phoneVO.getType());
        pstm.setBoolean(5, phoneVO.getActive());

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
}
