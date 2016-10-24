//import java.sql.Statement;
//import java.sql.Types;
//import java.io.File;
//import java.io.FileInputStream;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class Prepared_JdbcMain {
//
//	public static void main(String[] args) throws Exception {
//	}
//
//	public static void storePhoto() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
//
//		PreparedStatement pstmt =
//				con.prepareStatement("INSERT INTO EMP(?, ?, ?)");
//		pstmt.setInt(1,  200);
//		pstmt.setString(2,  "Tom");
//
//		File file = new File("d:/kp.jpg");
//		FileInputStream fis = new FileInputStream(file);
//		pstmt.setBinaryStream(3, fis, file.length());
//		pstmt.setAsciiStream(3, fis, file.length());
//		pstmt.executeUpdate();
//
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	public static void transactions() throws Exception {
//		Statement stmt = con.createStatement();
//
//		try {
//			con.setAutoCommit(false);
//			stmt.executeUpdate("UPDATE ACCOUNT SET BALANCE = "
//			+ (50000-10000) + " WHERE ACCNO = 500");
//			stmt.executeUpdate("UPDATE ACCOUNT SET BALANCE = "
//			+ (40000+10000) + " WHERE ACCNO = 600");
//			con.commit();
//		}
//		catch(SQLException e) {
//			con.rollback();
//		}
//		finally {
//			con.setAutoCommit(true);
//		}
//	}
//
//	public static void batchUpdates() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//OR
//		new oracle.jdbc.driver.OracleDriver();
//
//		Connection con = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
//
//		Statement stmt = con.createStatement();
//		stmt.addBatch("INSERT INTO EMP VALUES(----)");
//		stmt.addBatch("INSERT INTO EMP VALUES(----)");
//		stmt.addBatch("INSERT INTO EMP VALUES(----)");
//		stmt.addBatch("INSERT INTO EMP VALUES(----)");
//		int updations[] = stmt.executeBatch();
//
//		PreparedStatement pstmt =
//				con.prepareStatement("INSERT INTO EMP(?, ?, ?)");
//		pstmt.setInt(1,  200);
//		pstmt.setString(2,  "Tom");
//		pstmt.setDouble(3, 23000.89);
//		pstmt.addBatch();
//
//		pstmt.clearParameters();
//
//		pstmt.setInt(1,  201);
//		pstmt.setString(2,  "Jerry");
//		pstmt.setDouble(3, 53000.89);
//		pstmt.addBatch();
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//	public static void crudOperations() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//OR
//		new oracle.jdbc.driver.OracleDriver();
//
//		Connection con = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
//
//
//		CallableStatement cstmt = con.prepareCall("{ call update_sal(?, ?) }");
//		cstmt.setInt(1, 235);
//		cstmt.registerOutParameter(2, Types.FLOAT);
//		boolean result = cstmt.execute();
//		if(result == true) {
//			float updated_sal = cstmt.getFloat(2);
//		}
//
//
//		PreparedStatement pstmt = con.prepareStatement(
//				"UPDATE DEPT SET NAME = ? WHERE ID = ?");
//		pstmt.setString(1, "ResearchNDevelopment");
//		pstmt.setInt(2, 3);
//		int updates = pstmt.executeUpdate();
//		System.out.println("no of updates = " + updates);
//
//
//		PreparedStatement pstmt_delete = con.prepareStatement(
//		"DELETE FROM DEPT WHERE ID = ?");
//		pstmt_delete.setInt(1, 6);
//		updates = pstmt_delete.executeUpdate();
//		System.out.println("no of deletes = " + updates);
//
//		PreparedStatement pstmt_select = con.prepareStatement(
//		"SELECT * FROM DEPT");
//		ResultSet rs = pstmt_select.executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getInt("ID") + " - " + rs.getString("NAME"));
//		}
//
//
//		rs.close();
//		pstmt.close();
//		con.close();
//
//	}
//
//}
