package ex1.model.vo;

import java.util.ArrayList;

public class ClienteVO {
    private int id;
    private String name;
    private String cpf;
    private ArrayList<PhoneVO> phoneVOS;
    private AddressVO addressVO;

    public ClienteVO(String name, String cpf, AddressVO addressVO) {
        this.name = name;
        this.cpf = cpf;
        this.phoneVOS = phoneVOS;
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

    public ArrayList<PhoneVO> getPhones() {
        return phoneVOS;
    }

    public void setPhones(ArrayList<PhoneVO> phoneVOS) {
        this.phoneVOS = phoneVOS;
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
        return "Cliente{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", Phones=" + phoneVOS +
                ", adress=" + addressVO +
                '}';
    }
}
