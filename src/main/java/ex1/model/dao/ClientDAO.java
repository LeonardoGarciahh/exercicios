package ex1.model.dao;

import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.*;

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

    public boolean updateClient(ClienteVO clienteVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE CLIENTE set IDENDERECO = '" + clienteVO.getAdress().getId() + "', NOME = '"
                + clienteVO.getName() + "', CPF = '" + clienteVO.getCpf() +
                "'WHERE IDENDERECO = " + clienteVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de atualização do cliente.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public boolean deletClient(ClienteVO clienteVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "DELETE FROM CLIENTE WHERE IDCLIENTE = " + clienteVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que deleta o cliente.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }
}
