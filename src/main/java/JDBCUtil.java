import java.sql.*;

public class JDBCUtil {
    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    private static String url = "jdbc:hive2://bigdata01:10000/default";

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            return DriverManager.getConnection(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection conn, ResultSet result, Statement st) {
        if (result != null) {
            try {
                result.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
            result = null;
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
