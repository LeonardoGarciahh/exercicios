package ex1.model.dao;

import ex1.model.vo.AddressVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDAO {
    //inserir
    public Boolean addAdress(AddressVO adressVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO ENDERECO (RUA,CEP,CIDADE,ESTADO,UF) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setString(1, adressVO.getStreet());
        pstm.setString(2, adressVO.getCep());
        pstm.setString(3, adressVO.getCidade());
        pstm.setString(4,adressVO.getState());
        pstm.setString(5,adressVO.getUf());

        try {
            pstm.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastrar endereço.");
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            // Banco.closeStatement(stmt);
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);
            System.out.println("Endereço cadastrado cadastrado!");
            return true;
        }
    }

    // atualizar

    // remover

    //consultar

    //consultar todos
}
