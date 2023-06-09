package dao;

import com.solvd.laba.model.Address;

import java.util.List;

public interface IAddressDAO extends IBaseDAO<Address>{
    List<Address> getCityByStreet(String street);
}
