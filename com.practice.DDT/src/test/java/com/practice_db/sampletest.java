package com.practice_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sampletest {
	
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
	     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	    Statement stmt= conn.createStatement();
	   ResultSet resset=  stmt.executeQuery("select * from project1");
	   
	   while(resset.next())
	   {
		   System.out.println(resset.getString(1)+"\t"+resset.getString(2)+"\t"+resset.getString(3)+"\t"+resset.getString(4)+"\t"+resset.getString(5)+"\t"+resset.getString(6)+"\t");
	   }
	   
		}
		catch(Exception e)
		{
			System.out.println("handle any exception");
		}
		finally {
			   conn.close();

		}
	}

}
