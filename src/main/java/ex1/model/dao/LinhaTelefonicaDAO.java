package ex1.model.dao;

import ex1.controller.PhoneController;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class LinhaTelefonicaDAO {

    public LinhaTelefonicaVO associateWithClientAndPhone(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        Connection conn = Banco.getConnection();
        // Statement stmt = Banco.getStatement(conn);
        String query = "INSERT INTO LINHA_TELEFONICA (DT_ATIVACAO,DT_DESATIVACAO,IDCLIENTE,IDTELEFONE) VALUES(now(),null,?,?)";
        PreparedStatement pstm = Banco.getPreparedStatementWithPK(conn, query);
        pstm.setInt(1, linhaTelefonicaVO.getIdcliente());
        pstm.setInt(2, linhaTelefonicaVO.getIdtelefone());


        try {
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            linhaTelefonicaVO.setId(id);
            turnActive(linhaTelefonicaVO.getIdtelefone());
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastrar linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
            return null;
        } finally {
            // Banco.closeStatement(stmt);
            Banco.closePreparedStatement(pstm);
            Banco.closeConnection(conn);
            System.out.println("Linha telefonica cadastrado!");
            return linhaTelefonicaVO;
        }
    }

    public boolean updateLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE LINHA_TELEFONICA set DT_ATIVACAO = ?, DT_DESATIVACAO = ?, IDCLIENTE = ?, IDTELEFONE = ? WHERE IDLINHATELEFONICA = ?";


        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setDate(1, (Date) Date.from(linhaTelefonicaVO.getDT_ACTIVATION().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        pstm.setDate(2, (Date) Date.from(linhaTelefonicaVO.getDT_DESATIVATE().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        pstm.setInt(3, linhaTelefonicaVO.getIdcliente());
        pstm.setInt(4, linhaTelefonicaVO.getIdtelefone());
        pstm.setInt(5, linhaTelefonicaVO.getId());
        try {
            if (pstm.executeUpdate() == 1) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de atualiza????o da linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public boolean deletLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "DELETE FROM LINHA_TELEFONICA WHERE IDLINHATELEFONICA = ?";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        assert pstm != null;
        pstm.setInt(1, linhaTelefonicaVO.getId());
        try {
            if (pstm.executeUpdate() == 1) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que deleta a linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }


    public boolean disableLine(LinhaTelefonicaVO linhaTelefonicaVO) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        System.out.println(linhaTelefonicaVO.getId());
        String query = "UPDATE LINHA_TELEFONICA set DT_DESATIVACAO = now() where IDLINHATELEFONICA= ? ";

        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setInt(1, linhaTelefonicaVO.getId());

        try {
            if (pstm.execute(query) == true) {
                retorno = true;
            }
            PhoneController phoneController = new PhoneController();
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de ativa????o da linha telefonica.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return retorno;
    }

    public ArrayList<LinhaTelefonicaVO> findPhoneByClient(Integer idcliente) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;
        ArrayList<LinhaTelefonicaVO> telefoneVOlist = new ArrayList<LinhaTelefonicaVO>();
        PhoneVO phoneVO = new PhoneVO();

        query = "SELECT * FROM LINHA_TELEFONICA WHERE IDCLIENTE = ? and DT_DESATIVACAO IS NULL";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setInt(1, idcliente);
        PhoneController phoneController = new PhoneController();

        try {
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO();
                linhaTelefonicaVO.setId(resultado.getInt(1));
                linhaTelefonicaVO.setDT_ACTIVATION(LocalDate.parse((resultado.getString(2))));
                linhaTelefonicaVO.setDT_DESATIVATE((resultado.getString(3) != null)?LocalDate.parse((resultado.getString(3))):null);
                linhaTelefonicaVO.setIdcliente(resultado.getInt(4));
                linhaTelefonicaVO.setIdtelefone(resultado.getInt(5));

                telefoneVOlist.add(linhaTelefonicaVO);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca os telefones do cliente.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return telefoneVOlist;
    }

    public LinhaTelefonicaVO findLine(Integer idtelefone) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query;

        query = "SELECT * FROM LINHA_TELEFONICA WHERE IDTELEFONE = ? and DT_DESATIVACAO IS NULL";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setInt(1, idtelefone);

        PhoneController phoneController = new PhoneController();

                LinhaTelefonicaVO linhaTelefonicaVO = new LinhaTelefonicaVO();
        try {
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                linhaTelefonicaVO.setId(resultado.getInt(1));
                linhaTelefonicaVO.setIdcliente(resultado.getInt(4));
                linhaTelefonicaVO.setIdtelefone(resultado.getInt(5));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a query que busca a linha.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }

        return linhaTelefonicaVO;
    }

    public boolean turnActive(Integer idPhone) throws SQLException {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        boolean retorno = false;
        String query = "UPDATE TELEFONE set ATIVO = True where idtelefone= ?";
        PreparedStatement pstm = Banco.getPreparedStatement(conn, query);
        pstm.setInt(1, idPhone);

        try {
            if (pstm.execute() == true) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a query de ativa????o da linha telefonica.");
            System.out.println("Erro: " + e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return true;
    }

}
