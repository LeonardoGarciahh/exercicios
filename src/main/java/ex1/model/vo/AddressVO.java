package ex1.model.vo;

public class AddressVO {
    private int id;
    private String street;
    private String cep;
    private String state;
    private String uf;
    private String city;
    private Integer number;

    public AddressVO() {

    }

    public AddressVO(String street, Integer number, String cep, String uf, String city, String state) {
        this.street = street;
        this.cep = cep;
        this.uf = uf;
        this.city = city;
        this.number = number;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }



    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "id: "+id+
                ", Rua: '" + street + '\'' +
                ", Cep: '" + cep + '\'' +
                ", Uf: '" + uf + '\'' +
                ", Cidade: '" + city;
    }
}
