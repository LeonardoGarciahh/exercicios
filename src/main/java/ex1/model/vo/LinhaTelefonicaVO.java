package ex1.model.vo;

import java.time.LocalDate;

public class LinhaTelefonicaVO {
    private int id;
    private int idcliente;
    private int idtelefone;
    private LocalDate DT_ACTIVATION;
    private LocalDate DT_DESATIVATE;

    public LinhaTelefonicaVO(int idcliente, int idtelefone) {
        this.idcliente = idcliente;
        this.idtelefone = idtelefone;
    }

    public LinhaTelefonicaVO() {

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

    public LocalDate getDT_ACTIVATION() {
        return DT_ACTIVATION;
    }

    public void setDT_ACTIVATION(LocalDate DT_ACTIVATION) {
        this.DT_ACTIVATION = DT_ACTIVATION;
    }

    public LocalDate getDT_DESATIVATE() {
        return DT_DESATIVATE;
    }

    public void setDT_DESATIVATE(LocalDate DT_DESATIVATE) {
        this.DT_DESATIVATE = DT_DESATIVATE;
    }
}
