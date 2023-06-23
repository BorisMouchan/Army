package dao.myBatisImpl;

import com.solvd.laba.model.Address;
import dao.IAddressDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;


import java.util.List;

public class AddressDAO implements IAddressDAO,ISession {

    @Override
    public List<Address> getCityByStreet(String street) {
        try (SqlSession sqlSession = getSqlSession().openSession()) {
            List<Address> addresses = sqlSession.selectList("getCityByStreet", street);
            sqlSession.commit();
            return addresses;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Address address) {
    try(SqlSession sqlSession= getSqlSession().openSession()) {
        sqlSession.insert("saveAddress",address);
        sqlSession.commit();
        LOGGER.info("Address added");
        }
    }

    @Override
    public Address getEntityById(long id) {
        try(SqlSession sqlSession=getSqlSession().openSession()) {
            Address address = sqlSession.selectOne("getEntityById",id);
            sqlSession.commit();
            return address;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Address> getAll() {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Address> addresses = session.selectList("getAllAddresses");
            session.commit();
            return addresses;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Address address) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.update("updateAddress", address);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.delete("removeAddress", id);
            session.commit();
            LOGGER.info("The Address with ID = " + id + " has been removed successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }

    }
}
