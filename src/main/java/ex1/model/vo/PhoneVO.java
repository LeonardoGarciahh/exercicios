package ex1.model.vo;

public class PhoneVO {
    private int id;
    private String number;
    private Integer ddd;
    private Integer ddi;
    private int type;
    private Boolean active;

    public PhoneVO() {

    }

    public PhoneVO(String number, Integer ddd, Integer ddi, int type) {
        this.number = number;
        this.ddd = ddd;
        this.ddi = ddi;
        this.type = type;
        this.active = active;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }

    public int getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id +" - "+ ddi + ddd + number+" - "+active;
    }
}
