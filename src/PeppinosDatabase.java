import java.sql.*;

public class PeppinosDatabase {
    private Connection connetti() {
        final String databaseUrl = "jdbc:mysql://localhost:3306/motogp";
        final String username = "root";
        final String password =  "";
        Connection conn;
        try {
            conn = DriverManager.getConnection(databaseUrl,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public int insert(String tableName, int posizione, String nomePilota, int punti) {
        Connection conn = connetti();
        try {
            String table = "c" + tableName;
            Statement statement = conn.createStatement();
            String query = "INSERT INTO " + table + "(posizione, pilota, punti) VALUES(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, posizione);
            preparedStatement.setString(2, nomePilota);
            preparedStatement.setInt(3, punti);
            preparedStatement.executeUpdate();
            statement.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String select(String anno, String categoria) {
        Connection conn = connetti();
        try {
            Statement statement = conn.createStatement();
            String nomeTabella = "c" + anno + "c" + categoria;
            String query = "SELECT * FROM " + nomeTabella;
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder resultQuery = new StringBuilder();
            while (resultSet.next()) {
                resultQuery.append(resultSet.getString("posizione")).append("  |  ")
                        .append(resultSet.getString("pilota")).append("  |  ")
                        .append(resultSet.getString("punti")).append("\n");
            }
            statement.close();
            conn.close();
            if(!resultQuery.toString().equals("")) {
                return resultQuery.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Non ho trovato niente";
    }
}
