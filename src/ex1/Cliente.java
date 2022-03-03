package ex1;

import java.util.ArrayList;

public class Cliente {
    private String name;
    private String cpf;
    private ArrayList<Phone> Phones;
    private Adress adress;

    public Cliente(String name, String cpf, ArrayList<Phone> phones, Adress adress) {
        this.name = name;
        this.cpf = cpf;
        Phones = phones;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", Phones=" + Phones +
                ", adress=" + adress +
                '}';
    }
}
