package ex1.model.vo;

import java.time.LocalDate;
import java.util.Date;

public class LinhaTelefonicaVO {
    private int id;
    private int idcliente;
    private int idtelefone;
    private LocalDate Dt_Ativacao;
    private LocalDate Dt_Desativacao;

    public LinhaTelefonicaVO(int idcliente, int idtelefone) {
        this.idcliente = idcliente;
        this.idtelefone = idtelefone;
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

    public LocalDate getDt_Ativacao() {
        return Dt_Ativacao;
    }

    public void setDt_Ativacao(LocalDate dt_Ativacao) {
        Dt_Ativacao = dt_Ativacao;
    }

    public LocalDate getDt_Desativacao() {
        return Dt_Desativacao;
    }

    public void setDt_Desativacao(LocalDate dt_Desativacao) {
        Dt_Desativacao = dt_Desativacao;
    }
}
