package dao.jdbcMySQLImpl;

import com.solvd.laba.model.Address;
import dao.IAddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements IAddressDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public AddressDAO() {
    }

    @Override
    public void saveEntity(Address address) {
        Connection connection = pool.getConnection();
        String sql = "INSERT INTO ADDRESSES (CITY,STREET) VALUES((?),(?))";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, address.getCity());
            pr.setString(2, address.getStreet());
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public List<Address> getCityByStreet(String street) {
        Connection connection = pool.getConnection();
        List<Address> resultList = new ArrayList<>();
        String sql = "SELECT * FROM ADDRESSES WHERE street = (?)";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, street);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    Address address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setCity(rs.getString("city"));
                    address.setStreet(rs.getString("street"));
                    resultList.add(address);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return resultList;
    }


        @Override
        public Address getEntityById(long id) {
            Connection connection = pool.getConnection();
            Address result = new Address();
            String sql = "SELECT * FROM ADDRESSES WHERE id = (?)";
            try (PreparedStatement pr = connection.prepareStatement(sql)) {
                pr.setLong(1, id);
                pr.execute();
                try (ResultSet rs = pr.getResultSet()) {
                    while (rs.next()) {
                        result.setId(rs.getInt("id"));
                        result.setCity(rs.getString("city"));
                        result.setStreet(rs.getString("street"));

                    }
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        pool.releaseConnection(connection);
                    } catch (SQLException e) {
                        LOGGER.error(e.getMessage());
                    }
                }
            }
            return result;
        }

        @Override
        public List<Address> getAll () {
            Connection connection = pool.getConnection();
            List<Address> resultList = new ArrayList<>();
            String sql = "SELECT * FROM ADDRESSES ";
            try {
                PreparedStatement pr = connection.prepareStatement(sql);
                pr.execute();
                ResultSet resultSet = pr.getResultSet();
                while (resultSet.next()) {
                    Address address = new Address();
                    address.setId(resultSet.getLong("id"));
                    address.setStreet(resultSet.getString("Street"));
                    address.setStreet(resultSet.getString("City"));
                    resultList.add(address);
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        pool.releaseConnection(connection);
                    } catch (SQLException e) {
                        LOGGER.error(e.getMessage());
                    }
                }
            }
        return resultList;
        }

        @Override
        public void updateEntity (Address address){
            Connection connection = pool.getConnection();
            String sql = "UPDATE ADDRESSES SET city = (?), street = (?)" +  "where id=(?)";
            try {
                PreparedStatement pr = connection.prepareStatement(sql);
                pr.setString(1, address.getCity());
                pr.setString(2, address.getStreet());
                pr.setLong(3,address.getId());
                pr.executeUpdate();

            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                if(connection !=null) {
                    try {
                        pool.releaseConnection(connection);
                    } catch (SQLException e) {
                        LOGGER.error(e.getMessage());
                    }
                }
            }


        }

        @Override
        public void removeEntity ( long id){
            Connection connection = pool.getConnection();
            String sql = "DELETE FROM ADDRESSES where id = (?)";
            try (PreparedStatement pr = connection.prepareStatement(sql)) {
                pr.setLong(1, id);
                pr.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        pool.releaseConnection(connection);
                    } catch (SQLException e) {
                        LOGGER.error(e.getMessage());
                    }
                }
            }
        }
    }
