package ex1.model.dao;

import ex1.model.vo.Address;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
    //inserir
    public boolean cadastrarNovoChamadoDAO(Address adressVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO ENDERECO (STREET,CEP,UF,CITY) VALUES(?,?,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setString(1, adressVO.getStreet());
        pstm.setString(2, adressVO.getCep());
        pstm.setString(3, adressVO.getUf());
        pstm.setString(4,adressVO.getCidade());

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
