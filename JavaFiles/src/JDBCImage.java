import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

/**
 * Created by kulkarni_my on 10/24/2016.
 */
public class JDBCImage {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "invoker");
//
//        PreparedStatement ps = con.prepareStatement("insert into img_table values(?,?)");
//        ps.setString(1, "naruto");
//
//        FileInputStream fin = new FileInputStream("D:/d.jpg");
//        ps.setBinaryStream(2, fin, fin.available());
//        boolean i = ps.execute();
//        System.out.println(i + " records affected");

        PreparedStatement stmt = con.prepareStatement("SELECT * FROM IMG_TABLE WHERE NAME LIKE ?");
        stmt.setString(1, "%naruto%");
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            File image = new File("D:/java.jpg");
            FileOutputStream fos = new FileOutputStream(image);

            Blob blob = resultSet.getBlob(2);
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            fos.write(bytes);
        }
        con.close();
    }
}
