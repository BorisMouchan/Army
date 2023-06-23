package dao.jdbcMySQLImpl;

import com.solvd.laba.model.Commander;
import com.solvd.laba.model.Gun;
import dao.IGunsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GunsDAO implements IGunsDAO {
    private static final Logger LOGGER = LogManager.getLogger(CommandersDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public GunsDAO() {
    }

    @Override
    public void saveEntity(Gun gun) {
        Connection connection = pool.getConnection();
        String sql = "INSERT INTO GUNS (SERIAL_NUMBER,CALIBER) VALUES((?),(?))";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setLong(1, gun.getSerialNumber());
            pr.setLong(2, gun.getCaliber());
            pr.executeUpdate();
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
    public Gun getEntityById(long id) {
        Connection connection = pool.getConnection();
        Gun result = new Gun();
        String sql = "SELECT * FROM GUNS WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setLong(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setSerialNumber(rs.getLong("Serial_number"));
                    result.setCaliber(rs.getLong("Caliber"));
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
    public List<Gun> getAll() {
        {
            Connection connection = pool.getConnection();
            List<Gun> resultList = new ArrayList<>();
            String sql = "SELECT * FROM GUNS ";
            try {
                PreparedStatement pr = connection.prepareStatement(sql);
                pr.execute();
                ResultSet resultSet = pr.getResultSet();
                while (resultSet.next()) {
                    Gun gun = new Gun();
                    gun.setId(resultSet.getInt("id"));
                    gun.setSerialNumber(resultSet.getLong("Serial_number"));
                    gun.setCaliber(resultSet.getLong("Caliber"));
                    resultList.add(gun);
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
    }

    @Override
    public void updateEntity(Gun guns) {
        Connection connection = pool.getConnection();
        String sql = "UPDATE GUNS SET Serial_number = (?), Caliber = (?)" + "where id=(?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setLong(1, guns.getCaliber());
            pr.setLong(2, guns.getCaliber());
            pr.setLong(3, guns.getId());
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

    @Override
    public void removeEntity(long id) {
        Connection connection = pool.getConnection();
        String sql = "DELETE FROM GUNS where id = (?)";
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

    @Override
    public List<Gun> getGunsByCaliber(long caliber) {
        Connection connection = pool.getConnection();
        String sql = "SELECT * FROM GUNS where Caliber=(?)";
        List<Gun> resultList = new ArrayList<>();
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setLong(1, caliber);
            pr.execute();

            ResultSet rs = pr.getResultSet();
            while (rs.next()) {
                Gun gun = new Gun();
                gun.setId(rs.getLong("id"));
                gun.setSerialNumber(rs.getLong("Serial_number"));
                gun.setCaliber(rs.getLong("Caliber"));
                resultList.add(gun);
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
}
