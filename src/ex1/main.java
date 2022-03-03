package ex1;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args){

        Phone phone1 = new Phone("985009242", 48, 55, "Pré-pago", false);
        ArrayList<Phone> phones1 = new ArrayList<Phone>(Arrays.asList(phone1));
        Adress adress1 = new Adress("João Manoel Fernandes", "88067040", "SC", "Florianopolis");
        Cliente cliente1 = new Cliente("Leonardo", "130.055.499.17", phones1, adress1);
        System.out.print(cliente1.toString());
    }
}
