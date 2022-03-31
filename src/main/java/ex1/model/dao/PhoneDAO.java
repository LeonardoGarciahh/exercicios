package ex1.model.dao;

import ex1.controller.AddressController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.*;
import java.util.ArrayList;

public class PhoneDAO {
    public PhoneVO addPhone(PhoneVO phoneVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO TELEFONE (DDI,DDD,NUMERO,TIPO,ATIVO) VALUES(?,?,?,?,False)";
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

    public PhoneVO findPhone(Integer id){
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<PhoneVO> telefoneVOlist = new ArrayList<PhoneVO>();
        PhoneVO phoneVO = new PhoneVO();

            query = "SELECT * FROM TELEFONE WHERE IDTELEFONE = " + id;


        try {
            resultado = stmt.executeQuery(query);
            if (resultado.next()) {
                phoneVO.setId(resultado.getInt(1));
                phoneVO.setDdi(resultado.getInt(2));
                phoneVO.setDdd(resultado.getInt(3));
                phoneVO.setNumber(resultado.getString(4));
                phoneVO.setType(resultado.getInt(5));
                phoneVO.setActive(resultado.getBoolean(6));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os telefones.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return phoneVO;
    }

    public ArrayList<PhoneVO> findPhoneNotActive(){
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<PhoneVO> telefoneVOlist = new ArrayList<PhoneVO>();


        query = "SELECT * FROM TELEFONE WHERE ATIVO = 0";


        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                PhoneVO phoneVO = new PhoneVO();
                phoneVO.setId(resultado.getInt(1));
                phoneVO.setDdi(resultado.getInt(2));
                phoneVO.setDdd(resultado.getInt(3));
                phoneVO.setNumber(resultado.getString(4));
                phoneVO.setType(resultado.getInt(5));
                phoneVO.setActive(resultado.getBoolean(6));
                telefoneVOlist.add(phoneVO);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os telefones.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return telefoneVOlist;
    }
}
