package ex1.model.vo;

import java.util.Date;

public class LinhaTelefonicaVO {
    private int id;
    private int idcliente;
    private int idtelefone;
    private Date Dt_Ativacao;
    private Date Dt_Desativacao;

    public LinhaTelefonicaVO(int idcliente, int idtelefone, Date dt_Ativacao, Date dt_Desativacao) {
        this.idcliente = idcliente;
        this.idtelefone = idtelefone;
        Dt_Ativacao = dt_Ativacao;
        Dt_Desativacao = dt_Desativacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdtelefone() {
        return idtelefone;
    }

    public void setIdtelefone(int idtelefone) {
        this.idtelefone = idtelefone;
    }

    public Date getDt_Ativacao() {
        return Dt_Ativacao;
    }

    public void setDt_Ativacao(Date dt_Ativacao) {
        Dt_Ativacao = dt_Ativacao;
    }

    public Date getDt_Desativacao() {
        return Dt_Desativacao;
    }

    public void setDt_Desativacao(Date dt_Desativacao) {
        Dt_Desativacao = dt_Desativacao;
    }
}
