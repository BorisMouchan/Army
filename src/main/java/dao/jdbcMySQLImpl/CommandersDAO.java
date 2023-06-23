package dao.jdbcMySQLImpl;

import com.solvd.laba.model.Address;
import com.solvd.laba.model.Commander;
import dao.ICommandersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandersDAO implements ICommandersDAO {

    private static final Logger LOGGER = LogManager.getLogger(CommandersDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public CommandersDAO() {
    }


    @Override
    public void saveEntity(Commander commander) {
        Connection connection = pool.getConnection();
        String sql = "INSERT INTO COMMANDERS (TITLE,PERSON_COMMANDER_ID,SQUAD_ID) VALUES((?),(?),(?))";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, commander.getTitle());
            pr.setLong(2, commander.getPersonsId());
            pr.setLong(3, commander.getSquadId());
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
    public Commander getEntityById(long id) {
        Connection connection = pool.getConnection();
        Commander result = new Commander();
        String sql = "SELECT * FROM COMMANDERS WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setLong(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setTitle(rs.getString("Title"));
                    result.setPersonsId(rs.getLong("Person_commander_id"));
                    result.setSquadId(rs.getLong("Squad_id"));

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
    public List<Commander> getAll() {
        Connection connection = pool.getConnection();
        List<Commander> resultList = new ArrayList<>();
        String sql = "SELECT * FROM COMMANDERS ";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.execute();
            ResultSet resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Commander commander = new Commander();
                commander.setId(resultSet.getInt("id"));
                commander.setTitle(resultSet.getString("Title"));
                commander.setPersonsId(resultSet.getLong("Person_commander_id"));
                commander.setSquadId(resultSet.getLong("Squad_id"));
                resultList.add(commander);
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
    public void updateEntity(Commander commander) {
        Connection connection = pool.getConnection();
        String sql = "UPDATE COMMANDERS SET title = (?), Person_commander_id = (?), Squad_id = (?)" + "where id=(?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, commander.getTitle());
            pr.setLong(2, commander.getPersonsId());
            pr.setLong(3, commander.getSquadId());
            pr.setLong(4, commander.getId());
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
        String sql = "DELETE FROM COMMANDERS where id = (?)";
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
    public List<Commander> getCommanderByPersonId(long personsId) {
        Connection connection = pool.getConnection();
        String sql = "SELECT * FROM COMMANDERS where Person_commander_id=(?)";
        List<Commander> resultList = new ArrayList<>();
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setLong(1, personsId);
            pr.execute();

            ResultSet rs = pr.getResultSet();
            while (rs.next()) {
                Commander commander = new Commander();
                commander.setId(rs.getLong("id"));
                commander.setTitle(rs.getString("Title"));
                commander.setPersonsId(rs.getLong("Person_commander_id"));
                commander.setSquadId(rs.getLong("Squad_id"));
                commander.setName(rs.getString("Name"));
                resultList.add(commander);
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
