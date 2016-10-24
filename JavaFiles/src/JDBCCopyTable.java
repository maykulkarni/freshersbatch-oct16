import java.sql.*;

/**
 * Created by kulkarni_my on 10/24/2016.
 */
public class JDBCCopyTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "invoker");
        Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "invoker");
        String sql = "INSERT INTO users_two(" + "name," + "active," + "login," + "password)" + "VALUES(?,?,?,?)";

        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        PreparedStatement pstmt = con1.prepareStatement(sql);

        ResultSet rs = statement.executeQuery("SELECT * FROM users_one");
        while (rs.next()) {
            String nm = rs.getString(1);
            String ac = rs.getString(2);
            String log = rs.getString(3);
            String pass = rs.getString(4);
            pstmt.setString(1, nm);
            pstmt.setString(2, ac);
            pstmt.setString(3, log);
            pstmt.setString(4, pass);
            pstmt.executeUpdate();
        }
        con.close();
        con1.close();
    }
}
