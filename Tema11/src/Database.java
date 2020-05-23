import java.sql.*;

public class Database {
    private static Database single_instance = null;
    private static Connection connection = null;
    private Database() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE","student","STUDENT");
    }

    public static Database getInstance() throws SQLException, ClassNotFoundException {
        if(single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    public PreparedStatement getStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void endConnection() throws SQLException {
        connection.close();
    }

}
