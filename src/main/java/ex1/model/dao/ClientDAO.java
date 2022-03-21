package ex1.model.dao;

import ex1.controller.AddressController;
import ex1.controller.LinhaTelefonicaController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.*;
import java.util.ArrayList;

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
                "'WHERE IDCLIENTE = " + clienteVO.getId();
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

    public ClienteVO findClient(int id) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<ClienteVO> clienteVOList = new ArrayList<ClienteVO>();
        ClienteVO clienteVO = new ClienteVO();
        AddressController addressController = new AddressController();
        LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
        if (id > 0) {
            query = "SELECT * FROM CLIENTE WHERE IDCLIENTE = " + id;
        } else {
            query = "SELECT * FROM CLIENTE";
        }

        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                clienteVO.setId(resultado.getInt(1));
                clienteVO.setAdress(addressController.findAddress(resultado.getInt(2)));
                clienteVO.setName(resultado.getString(3));
                clienteVO.setCpf(resultado.getString(4));
                clienteVO.setPhones(linhaTelefonicaController.findPhoneByClient(id));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os clientes.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return clienteVO;
    }

    public boolean findClientByCpf(String cpf) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        boolean result = false;

        ClienteVO clienteVO = new ClienteVO();
        AddressController addressController = new AddressController();
        LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
        if (cpf != "") {
            query = "SELECT * FROM CLIENTE WHERE CPF = " + cpf;
        } else {
            query = "SELECT * FROM CLIENTE";
        }

        try {
            resultado = stmt.executeQuery(query);
            if (resultado.next()) {
                clienteVO.setId(resultado.getInt(1));
                clienteVO.setAdress(addressController.findAddress(resultado.getInt(2)));
                clienteVO.setName(resultado.getString(3));
                clienteVO.setCpf(resultado.getString(4));
                result = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os clientes pelo cpf.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return result;
    }
}
