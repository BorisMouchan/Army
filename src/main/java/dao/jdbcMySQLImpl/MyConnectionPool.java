package dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class MyConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(MyConnectionPool.class);
    private static MyConnectionPool instance = null;
    private static final int INITIAL_POOL_SIZE = 5;



    private MyConnectionPool() {
    }

    private static Vector<Connection> freeConnections = new Vector<>();
    private static Vector<Connection> usedConnections = new Vector<>();

    public static synchronized MyConnectionPool getInstance() {
        if (instance == null) {
            instance = new MyConnectionPool();
            create();
        }
        return instance;
    }

    public static void create() {
        String url = "jdbc:mysql://localhost:3306/army";
        String userName = "root";
        String password = "Mandar1ne";
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(createConnection(url, userName, password));
        }
    }

    public synchronized Connection getConnection() {
        Connection connection = freeConnections.remove(freeConnections.size() - 1);
        usedConnections.add(connection);
        LOGGER.info("CONNECTION IS GOING...");
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        if (usedConnections.remove(connection)) {
            freeConnections.add(connection);
            LOGGER.info("CONNECTION IS FREE NOW");
        } else {
            throw new SQLException("The connection has already returned or it's not for this pool.");
        }
    }

    private static Connection createConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
