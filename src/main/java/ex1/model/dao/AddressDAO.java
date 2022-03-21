package ex1.model.dao;

import ex1.model.vo.AddressVO;

import java.sql.*;
import java.util.ArrayList;

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

    public boolean updateAddress(AddressVO addressVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE ENDERECO set RUA = '" + addressVO.getStreet() + "', CEP = '"
                + addressVO.getCep() + "', CIDADE = '" + addressVO.getCidade() + "', ESTADO = '" + addressVO.getState()
                + "', UF = '" + addressVO.getUf() + "', NUMERO = '" + addressVO.getNumero()
                + "' WHERE IDENDERECO = " + addressVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de atualização do endereço.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public boolean deletAdress(AddressVO addressVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "DELETE FROM ENDERECO WHERE IDENDERECO = " + addressVO.getId();
        try {
            if (stmt.executeUpdate(query) == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que deleta o endereço.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public AddressVO findAddress(int id) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        AddressVO addressVO = new AddressVO();

        if (id > 0) {
            query = "SELECT * FROM ENDERECO WHERE IDENDERECO = " + id;
        } else {
            query = "SELECT * FROM ENDERECO";
        }

        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                addressVO.setId(resultado.getInt(1));
                addressVO.setStreet(resultado.getString(2));
                addressVO.setCep(resultado.getString(3));
                addressVO.setCidade(resultado.getString(4));
                addressVO.setState(resultado.getString(5));
                addressVO.setUf(resultado.getString(6));
                addressVO.setNumero(resultado.getInt(7));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os endereços.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return addressVO;
    }
    //consultar

    //consultar todos
    public ArrayList<AddressVO> findAllAddress() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<AddressVO> addressList = new ArrayList<AddressVO>();

            query = "SELECT * FROM ENDERECO";


        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                AddressVO addressVO = new AddressVO();
                addressVO.setId(resultado.getInt(1));
                addressVO.setStreet(resultado.getString(2));
                addressVO.setCep(resultado.getString(3));
                addressVO.setCidade(resultado.getString(4));
                addressVO.setState(resultado.getString(5));
                addressVO.setUf(resultado.getString(6));
                addressVO.setNumero(resultado.getInt(7));
                addressList.add(addressVO);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os endereços.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return addressList;
    }
}
