package ex1;

import ex1.controller.AddressController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.PhoneVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws SQLException {

        PhoneVO phoneVO1 = new PhoneVO("985009242", 48, 55, "Pré-pago", false);

        ArrayList<PhoneVO> phones1 = new ArrayList<PhoneVO>(Arrays.asList(phoneVO1));

        AddressVO addressVO1 = new AddressVO("João Manoel Fernandes", "88067040", "SC", "Florianopolis");
        AddressController adressController = new AddressController();
        adressController.addAdress(addressVO1);
        ClienteVO client1 = new ClienteVO("Leonardo", "130.055.499.17", phones1, addressVO1);

        System.out.print(client1.toString());
    }
}
