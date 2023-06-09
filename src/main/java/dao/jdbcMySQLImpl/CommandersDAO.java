package dao.jdbcMySQLImpl;

import com.solvd.laba.model.Address;
import com.solvd.laba.model.Commanders;
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
    public void saveEntity(Commanders commanders) {
        Connection connection = pool.getConnection();
        String sql = "INSERT INTO COMMANDERS (TITLE,PERSON_ID,SQUAD_ID) VALUES((?),(?),(?))";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, commanders.getTitle());
            pr.setLong(2, commanders.getPersonsId());
            pr.setLong(3, commanders.getSquadId());
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
    public Commanders getEntityById(long id) {
        Connection connection = pool.getConnection();
        Commanders result = new Commanders();
        String sql = "SELECT * FROM COMMANDERS WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setLong(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setTitle(rs.getString("Title"));
                    result.setPersonsId(rs.getLong("Person_id"));
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
    public List<Commanders> getAll () {
        Connection connection = pool.getConnection();
        List<Commanders> resultList = new ArrayList<>();
        String sql = "SELECT * FROM COMMANDERS ";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.execute();
            ResultSet resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Commanders commanders = new Commanders();
                commanders.setId(resultSet.getInt("id"));
                commanders.setTitle(resultSet.getString("Title"));
                commanders.setPersonsId(resultSet.getLong("Person_id"));
                commanders.setSquadId(resultSet.getLong("Squad_id"));
                resultList.add(commanders);
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
    public void updateEntity(Commanders commanders) {
        Connection connection = pool.getConnection();
        String sql = "UPDATE COMMANDERS SET title = (?), Person_id = (?), Squad_id = (?)" +  "where id=(?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, commanders.getTitle());
            pr.setLong(2, commanders.getPersonsId());
            pr.setLong(3, commanders.getSquadId());
            pr.setLong(4,commanders.getId());
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
    public List<Commanders> getCommanderByPersonId(long personsId) {
        Connection connection = pool.getConnection();
        String sql ="SELECT * FROM COMMANDERS where Person_id=(?)";
        List<Commanders> resultList = new ArrayList<>();
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setLong(1,personsId);
            pr.execute();

            ResultSet rs = pr.getResultSet();
            while (rs.next()){
                Commanders commanders = new Commanders();
                commanders.setId(rs.getLong("id"));
                commanders.setTitle(rs.getString("Title"));
                commanders.setPersonsId(rs.getLong("Person_id"));
                commanders.setSquadId(rs.getLong("Squad_id"));
                commanders.setName(rs.getString("Name"));
                resultList.add(commanders);
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
