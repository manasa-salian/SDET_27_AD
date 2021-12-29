package com.rmgyantra.TestScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AddingRowInDatabase {

//register
	
public static void main(String[] args) throws SQLException {
	Connection connection=null;
	try {
		Driver driver = new Driver();
	
	DriverManager.registerDriver(driver);
	//establish
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	//issue stmt
	Statement statement = connection.createStatement();
	//execute query
	int result = statement.executeUpdate("insert into project (project_id,created_by,project_name,status, team_size) values(102,'sugar','infosys','completed',0)");
	if(result==1) {
		System.out.println("row added");
	}
	else {
		System.out.println("row not added");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
	connection.close();
	}
}

}


