package dao.myBatisImpl;

import com.solvd.laba.model.Person;
import dao.IPersonsDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import java.util.List;

public class PersonDAO implements IPersonsDAO,ISession {
    @Override
    public void saveEntity(Person person) {
        try(SqlSession sqlSession=getSqlSession().openSession()){
            sqlSession.insert("saveEntity",person);
            sqlSession.commit();
            LOGGER.info("Person added");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Person getEntityById(long id) {
        try (SqlSession sqlSession=getSqlSession().openSession()){
            Person person = sqlSession.selectOne("getEntityById",id);
            sqlSession.commit();
            return person;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        try(SqlSession sqlSession=getSqlSession().openSession()) {
            List<Person> personList = sqlSession.selectList("getAll");
            sqlSession.commit();
            return personList;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Person person) {
        try(SqlSession sqlSession = getSqlSession().openSession()) {
            sqlSession.update("updateEntity",person);
            sqlSession.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(long id) {
        try(SqlSession sqlSession= getSqlSession().openSession()){
            sqlSession.delete("removeEntity",id);
            sqlSession.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Person getPersonById(long id) {
        try(SqlSession sqlSession= getSqlSession().openSession()) {
            Person person = sqlSession.selectOne("getPersonById",id);
            sqlSession.commit();
            return person;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
