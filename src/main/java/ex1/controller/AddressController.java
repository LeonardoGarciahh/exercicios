package ex1.controller;

import ex1.model.bo.AddressBO;
import ex1.model.vo.AddressVO;

import java.sql.SQLException;

public class AddressController {

    public AddressVO addAdress(AddressVO adressVO) throws SQLException {
        AddressBO adressBO = new AddressBO();
        return adressBO.addAdress(adressVO);
    }

    public Boolean deletAdress(AddressVO adressVO) throws SQLException {
        AddressBO adressBO = new AddressBO();
        return adressBO.deletAdress(adressVO);
    }

    public Boolean updateAddress(AddressVO adressVO) throws SQLException {
        AddressBO adressBO = new AddressBO();
        return adressBO.updateAddress(adressVO);
    }

}
