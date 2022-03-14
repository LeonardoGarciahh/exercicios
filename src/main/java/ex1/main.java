package ex1;

import ex1.controller.AddressController;
import ex1.controller.ClienteController;
import ex1.controller.LinhaTelefonicaController;
import ex1.controller.PhoneController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;
import ex1.views.Register;
import ex1.views.Telefone;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws SQLException {

//        Register.showScreen();
        Telefone.showScreen();
//        PhoneVO phoneVO1 = new PhoneVO("985009242", 48, 55, 0, false);
//        PhoneController phoneController = new PhoneController();
//        PhoneVO phoneDB = phoneController.addPhone(phoneVO1);
//
//        ArrayList<PhoneVO> phones1 = new ArrayList<PhoneVO>(Arrays.asList(phoneVO1));
//
//        AddressVO addressVO1 = new AddressVO("João Manoel Fernandes",112, "88067040", "SC", "Florianopolis","Santa Catarina");
//        AddressController adressController = new AddressController();
//        AddressVO adressDB = adressController.addAdress(addressVO1);
//
//        ClienteVO client1 = new ClienteVO("Leonardo", "13005549917", addressVO1);
//        ClienteController clienteController = new ClienteController();
//        ClienteVO clientDB = clienteController.addClient(client1);
//
//        LinhaTelefonicaVO linha1 = new LinhaTelefonicaVO(clientDB.getId(),phoneDB.getId(),null);
//        LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
//        linhaTelefonicaController.associateWithClientAndPhone(linha1);
//
//        System.out.print(client1.toString());
    }
}
