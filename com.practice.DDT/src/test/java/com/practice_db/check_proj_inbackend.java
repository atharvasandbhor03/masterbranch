package com.practice_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class check_proj_inbackend {
	
	@Test
	public void proj_check_test() throws SQLException
	{
		boolean flag=false;
		String expdata="ABCPROJ";
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	    Statement stmt= conn.createStatement();
	   ResultSet resset=  stmt.executeQuery("select * from project");
	   
	   while(resset.next())
	   {
		   String actdata=resset.getString(4);
		   if(expdata.equals(actdata))
		   {
			   flag=true;
			   System.out.println(expdata+" is avilable ====>PASS");
		   }
	   }
	   
	   if(flag==false)
	   {
		   System.out.println(expdata+" is not avilable ====>FAIL");
		   Assert.fail();
	   }
	   
	   conn.close();
	}

}
