package ex1.model.dao;

import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    public ClienteVO addClient(ClienteVO clienteVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO CLIENTE (IDENDERECO,NOME,CPF) VALUES(?,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatementWithPK(conn, query);
        pstm.setInt(1, clienteVO.getAdress().getId());
        pstm.setString(2, clienteVO.getName());
        pstm.setString(3, clienteVO.getCpf());

        try {
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            clienteVO.setId(id);
            System.out.println(clienteVO.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastrar cliente.");
            System.out.println("Erro: " + e.getMessage());
            return null;
        } finally {
            // Banco.closeStatement(stmt);
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);
            System.out.println("Cliente cadastrado cadastrado!");
            return clienteVO;
        }
    }
}
