package ex1;

public class Phone {
    private String number;
    private Integer ddd;
    private Integer ddi;
    private String type;
    private Boolean active;

    public Phone(String number, Integer ddd, Integer ddi, String type, Boolean active) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
