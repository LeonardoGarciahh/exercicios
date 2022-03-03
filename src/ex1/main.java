package ex1;

import ex1.model.vo.Address;
import ex1.model.vo.Cliente;
import ex1.model.vo.Phone;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args){

        Phone phone1 = new Phone("985009242", 48, 55, "Pré-pago", false);
        ArrayList<Phone> phones1 = new ArrayList<Phone>(Arrays.asList(phone1));

        Address address1 = new Address("João Manoel Fernandes", "88067040", "SC", "Florianopolis");

        Cliente client1 = new Cliente("Leonardo", "130.055.499.17", phones1, address1);

        System.out.print(client1.toString());
    }
}
