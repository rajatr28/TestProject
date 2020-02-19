package common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Service {
	static Connection connection;
	public static Connection getMySqlConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/gla","root","");
			System.out.println("connected");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return connection;
	}
	public static void addRecord()
	{
		try
		{
			Connection conn=getMySqlConnection();
			String query="insert into users(username,password)" + " values(?,?)";
			PreparedStatement preparedStmt=conn.prepareStatement(query);
			preparedStmt.setString(1, "medha");
			preparedStmt.setString(2, "medha");
			preparedStmt.execute();
			System.out.println("Inserted successfully");
			conn.close();
		}
		catch(Exception e)
		{
			System.err.println("Got an exceptional!");
			System.err.println(e.getMessage());
		}
	}
	public static void updateRecord()
	{
		try
		{
			Connection conn=getMySqlConnection();
			String query="update users set username=?,password=? where id=?";
			PreparedStatement preparedStmt=conn.prepareStatement(query);
			preparedStmt.setString(1, "garima");
			preparedStmt.setString(2, "ajh");
			preparedStmt.setInt(3,5);
			preparedStmt.executeUpdate();
			System.out.println("updated");
			conn.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		System.out.println(getMySqlConnection());
		addRecord();
		updateRecord();
	}
	
	

}
