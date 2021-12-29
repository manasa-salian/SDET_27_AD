package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {
	public static void main(String[] args) throws SQLException {
		//register database
String expectedfname="spoo";
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	//establish connection
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	//issue statement
	Statement statement = connection.createStatement();
	//execute query
	
  ResultSet result =statement.executeQuery("select * from studentinfo");
  while(result.next()) {
	  if(result.getString(2).equals(expectedfname)) {
		  System.out.println("passed");
	  }
	  }
  connection.close();
	}
}

