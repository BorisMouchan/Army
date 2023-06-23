package dao;

import com.solvd.laba.model.Medic;
import dao.enums.SpecializationType;

import java.util.List;

public interface IMedicDAO extends IBaseDAO<Medic>{
    List<Medic> getMedicBySpecialization(SpecializationType specializationType);
}
