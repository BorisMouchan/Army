package dao.myBatisImpl;

import com.solvd.laba.model.Medic;
import com.solvd.laba.model.Person;
import dao.IBaseDAO;
import dao.IMedicDAO;
import dao.enums.SpecializationType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import java.util.List;

public class MedicDAO implements IMedicDAO, ISession {
    @Override
    public void saveEntity(Medic medic) {
        try (SqlSession sqlSession = getSqlSession().openSession()) {
            sqlSession.insert("saveMedic", medic);
            sqlSession.commit();
            LOGGER.info("Medic added");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }


    @Override
    public Medic getEntityById(long id) {
        try (SqlSession sqlSession=getSqlSession().openSession()){
            Medic medic = sqlSession.selectOne("getMedicById",id);
            sqlSession.commit();
            return medic;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Medic> getAll() {
        try(SqlSession sqlSession=getSqlSession().openSession()) {
            List<Medic> medicList = sqlSession.selectList("getAllMedics");
            sqlSession.commit();
            return medicList;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Medic medic) {
        try(SqlSession sqlSession = getSqlSession().openSession()) {
            sqlSession.update("updateMedic",medic);
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
    public List<Medic> getMedicBySpecialization(SpecializationType specializationType) {
        try(SqlSession sqlSession= getSqlSession().openSession()) {
            List<Medic> medicList = sqlSession.selectList("getMedicBySpecialization",specializationType);
            sqlSession.commit();
            return medicList;
        }catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
