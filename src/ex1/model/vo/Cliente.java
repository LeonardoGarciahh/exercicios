package ex1.model.vo;

import java.util.ArrayList;

public class Cliente {
    private String name;
    private String cpf;
    private ArrayList<Phone> Phones;
    private Address address;

    public Cliente(String name, String cpf, ArrayList<Phone> phones, Address address) {
        this.name = name;
        this.cpf = cpf;
        Phones = phones;
        this.address = address;
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

    public ArrayList<Phone> getPhones() {
        return Phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        Phones = phones;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", Phones=" + Phones +
                ", adress=" + address +
                '}';
    }
}
