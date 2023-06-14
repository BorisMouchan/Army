package dao;

import com.solvd.laba.model.Commander;

import java.util.List;

public interface ICommandersDAO extends IBaseDAO<Commander> {
    List<Commander> getCommanderByPersonId (long personsId);
}
