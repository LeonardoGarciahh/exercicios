package ex1.model.selectors;

public class PhoneSelector {
    private Integer ddd;
    private String telefone;
    private Integer type;


    public PhoneSelector() {
    }

    public PhoneSelector(Integer ddd, String telefone, Integer type) {
        this.ddd = ddd;
        this.telefone = telefone;
        this.type = type;
    }

    public Boolean temFiltro(){
        if(ddd > 0){
            return true;
        }
        if(!telefone.equals("") && telefone.trim().length() > 0){
            return true;
        }
        if(type == 0 || type == 1){
            return true;
        }
        return false;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
