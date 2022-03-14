package ex1.model.vo;

public class AddressVO {
    private int id;
    private String street;
    private String cep;
    private String state;
    private String uf;
    private String cidade;
    private Integer numero;

    public AddressVO() {

    }

    public AddressVO(String street, Integer numero, String cep, String uf, String cidade, String state) {
        this.street = street;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.numero = numero;
        this.state = state;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }



    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", cep='" + cep + '\'' +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
