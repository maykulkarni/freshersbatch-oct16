import java.sql.*;

/**
 * Created by kulkarni_my on 10/21/2016.
 */

public class SQLDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "invoker");

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select * from emp");
        PreparedStatement pstmt = con.prepareStatement("UPDATE EMP SET SALARY = ? WHERE ID = ?");
        pstmt.setInt(1, 1500);
        pstmt.setInt(2, 1);
        System.out.println(pstmt.executeUpdate() + " rows updated");

        while (rs.next())
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        con.close();

    }

}
