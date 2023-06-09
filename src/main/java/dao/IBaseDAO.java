package dao;

import java.util.List;

public interface IBaseDAO <Entity>{

    // create
    void saveEntity(Entity model);

    //read
    Entity getEntityById(long id);
    List<Entity> getAll();

    //update
    void updateEntity(Entity model);

    //delete
    void removeEntity(long id);

}
