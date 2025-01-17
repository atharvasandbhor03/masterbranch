package com.practice_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class executeupdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	    Statement stmt= conn.createStatement();
	   int result=  stmt.executeUpdate("INSERT INTO project VALUES ('TY_PROJ_1003', 'NETRA','12/03/2022', 'ABCPROJ','ONGOING',60)");
	   System.out.println(result);
	   conn.close();
	}

}
