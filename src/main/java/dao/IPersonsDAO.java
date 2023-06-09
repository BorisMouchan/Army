package dao;

import com.solvd.laba.model.Persons;

public interface IPersonsDAO extends IBaseDAO<Persons> {
    Persons getPersonById(long id);
}
