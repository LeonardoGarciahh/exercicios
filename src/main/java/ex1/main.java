package ex1;

import ex1.controller.AddressController;
import ex1.controller.ClienteController;
import ex1.controller.LinhaTelefonicaController;
import ex1.controller.PhoneController;
import ex1.model.vo.AddressVO;
import ex1.model.vo.ClienteVO;
import ex1.model.vo.LinhaTelefonicaVO;
import ex1.model.vo.PhoneVO;
import ex1.views.DeletClient;
import ex1.views.Menu;
import ex1.views.Register;
import ex1.views.Telefone;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws SQLException {

        Menu.showScreen();

    }
}
