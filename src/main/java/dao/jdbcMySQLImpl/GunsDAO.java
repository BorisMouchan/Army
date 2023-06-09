package dao.jdbcMySQLImpl;

import com.solvd.laba.model.Commanders;
import com.solvd.laba.model.Guns;
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
    public void saveEntity(Guns guns) {
        Connection connection = pool.getConnection();
        String sql = "INSERT INTO GUNS (SERIAL_NUMBER,CALIBER) VALUES((?),(?))";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setLong(1, guns.getSerialNumber());
            pr.setLong(2, guns.getCaliber());
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
    public Guns getEntityById(long id) {
    Connection connection = pool.getConnection();
    Guns result = new Guns();
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
    public List<Guns> getAll() {
        {
            Connection connection = pool.getConnection();
            List<Guns> resultList = new ArrayList<>();
            String sql = "SELECT * FROM GUNS ";
            try {
                PreparedStatement pr = connection.prepareStatement(sql);
                pr.execute();
                ResultSet resultSet = pr.getResultSet();
                while (resultSet.next()) {
                    Guns guns = new Guns();
                    guns.setId(resultSet.getInt("id"));
                    guns.setSerialNumber(resultSet.getLong("Serial_number"));
                    guns.setCaliber(resultSet.getLong("Caliber"));
                    resultList.add(guns);
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
    public void updateEntity(Guns guns) {
        Connection connection = pool.getConnection();
        String sql = "UPDATE GUNS SET Serial_number = (?), Caliber = (?)" +  "where id=(?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setLong(1, guns.getCaliber());
            pr.setLong(2, guns.getCaliber());
            pr.setLong(3, guns.getId());
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
    public List<Guns> getGunsByCaliber(long caliber) {
        Connection connection = pool.getConnection();
        String sql ="SELECT * FROM GUNS where Caliber=(?)";
        List<Guns> resultList = new ArrayList<>();
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setLong(1,caliber);
            pr.execute();

            ResultSet rs = pr.getResultSet();
            while (rs.next()){
                Guns guns = new Guns();
                guns.setId(rs.getLong("id"));
                guns.setSerialNumber(rs.getLong("Serial_number"));
                guns.setCaliber(rs.getLong("Caliber"));
                resultList.add(guns);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection !=null) {
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
