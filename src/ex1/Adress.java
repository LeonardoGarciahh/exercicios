package ex1;

public class Adress {
    private String street;
    private String cep;
    private String uf;
    private String cidade;

    public Adress(String street, String cep, String uf, String cidade) {
        this.street = street;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
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
}
