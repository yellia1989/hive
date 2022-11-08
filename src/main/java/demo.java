import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConn();
            st = conn.createStatement();

            rs = st.executeQuery("select * from emp");
            while (rs.next()) {
                String name = rs.getString("first_name");
                int no = rs.getInt("stu_no");
                System.out.println("name: " + name + ", no: " + no);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JDBCUtil.release(conn, rs, st);
    }
}
