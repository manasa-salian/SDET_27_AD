package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetTheDataFromDataBase {
public static void main(String[] args) throws SQLException {
	//register the database
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//establish connection
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
	//issue the stmt
	 
	Statement statement = connection.createStatement();
	
	//execute query
	
	ResultSet result = statement.executeQuery("select *from studentinfo");
	while(result.next()) {
	 System.out.println(result.getString(1)+"\t"+result.getString(2));
		// System.out.println(result.getInt(1)+"\t"+result.getString(2));
	}
 connection.close();
}
}
