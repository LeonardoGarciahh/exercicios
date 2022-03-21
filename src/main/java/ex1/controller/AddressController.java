package ex1.controller;

import ex1.model.bo.AddressBO;
import ex1.model.vo.AddressVO;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public AddressVO findAddress(int id) throws SQLException {
        AddressBO adressBO = new AddressBO();
        return adressBO.findAddress(id);
    }
    public ArrayList<AddressVO> findAllAddress() throws SQLException {
        AddressBO adressBO = new AddressBO();
        return adressBO.findAllAddress();
    }

}
