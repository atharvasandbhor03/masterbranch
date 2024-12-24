package com.practice.ddtproperty;

import org.testng.annotations.Test;

public class readmvnparafromcmd_1_1 {
	
	@Test
	public void runtimepara()
	{
		
		String str=System.getProperty("url");
		String str1=System.getProperty("browser");
		String str2=System.getProperty("username");
		String str3=System.getProperty("password");
	System.out.println(str);
	System.out.println(str1);
	System.out.println(str2);
	System.out.println(str3);

	
	
		
	}

}
