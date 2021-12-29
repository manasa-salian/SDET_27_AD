package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase {
	

	public static void main(String[] args) throws SQLException {
	//register the database
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//establish teh connection
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
		//issue the statement
		
		Statement statement = connection.createStatement();
		//execute query
		
		int result=statement.executeUpdate("insert into studentinfo(fname,lname,address) values('spoo','jain','xyz')");
		//verification
		if(result==1) {
			System.out.println("===>one set of data is added");
		}
		else {
			System.out.println("===>no data is added");
		}
		//close teh database
		
		connection.close();
	}

		
	}


