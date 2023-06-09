package dao;

import com.solvd.laba.model.Vehicles;

import java.util.List;

public interface IVehiclesDAO extends IBaseDAO<Vehicles> {
    List<Vehicles> getVehiclesByYear(int year);

}
