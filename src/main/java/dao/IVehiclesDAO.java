package dao;

import com.solvd.laba.model.Vehicle;

import java.util.List;

public interface IVehiclesDAO extends IBaseDAO<Vehicle> {
    List<Vehicle> getVehiclesByYear(int year);

}
