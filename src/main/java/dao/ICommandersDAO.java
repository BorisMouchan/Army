package dao;

import com.solvd.laba.model.Commanders;

import java.util.List;

public interface ICommandersDAO extends IBaseDAO<Commanders> {
    List<Commanders> getCommanderByPersonId (long personsId);
}
