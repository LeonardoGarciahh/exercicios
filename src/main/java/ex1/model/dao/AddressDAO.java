package ex1.model.dao;

import ex1.model.vo.AddressVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO {
    //inserir
    public AddressVO addAdress(AddressVO adressVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO ENDERECO (RUA,CEP,CIDADE,ESTADO,UF,NUMERO) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatementWithPK(conn, query);
        pstm.setString(1, adressVO.getStreet());
        pstm.setString(2, adressVO.getCep());
        pstm.setString(3, adressVO.getCidade());
        pstm.setString(4,adressVO.getState());
        pstm.setString(5,adressVO.getUf());
        pstm.setInt(6,adressVO.getNumero());

        try {
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            adressVO.setId(id);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastrar endereço.");
            System.out.println("Erro: " + e.getMessage());
            return null;
        } finally {
            // Banco.closeStatement(stmt);
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);
            System.out.println("Endereço cadastrado cadastrado!");
            return adressVO;
        }
    }

    // atualizar

    // remover

    //consultar

    //consultar todos
}
