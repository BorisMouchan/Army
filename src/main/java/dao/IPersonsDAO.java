package dao;

import com.solvd.laba.model.Person;

public interface IPersonsDAO extends IBaseDAO<Person> {
    Person getPersonById(long id);
}
