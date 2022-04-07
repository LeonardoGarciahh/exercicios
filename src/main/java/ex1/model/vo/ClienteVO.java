package ex1.model.vo;

import java.util.ArrayList;

public class ClienteVO {
    private int id;
    private String name;
    private String cpf;
    private ArrayList<LinhaTelefonicaVO> LinhaTelefonicaVO;
    private AddressVO addressVO;

    public ClienteVO() {

    }

    public ClienteVO(String name, String cpf, AddressVO addressVO) {
        this.name = name;
        this.cpf = cpf;
        this.LinhaTelefonicaVO = LinhaTelefonicaVO;
        this.addressVO = addressVO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<LinhaTelefonicaVO> getPhones() {
        return LinhaTelefonicaVO;
    }

    public void setPhones(ArrayList<LinhaTelefonicaVO> phoneVOS) {
        this.LinhaTelefonicaVO = phoneVOS;
    }

    public AddressVO getAdress() {
        return addressVO;
    }

    public void setAdress(AddressVO addressVO) {
        this.addressVO = addressVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+" - "+ name;
    }
}
