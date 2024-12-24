package com.practice.ddtproperty;

import java.util.Random;

public class random_alphanumericRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//*****************int random num generation
//				Random random=new Random();
//				int random_num= random.nextInt(1000);
//				System.out.println(random_num);
//				
		//******** genrate alphanumeric random number
				String alphanumeric="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
				int n=20;//20number size required
				
				StringBuilder sb=new StringBuilder(n);
				for(int i=0;i<n;i++)
				{
				int index=(int) (alphanumeric.length()*Math.random()); 
				System.out.println(index);// alphanumeric value index
				
				sb.append(alphanumeric.charAt(index));//char at that index added to sb
				
				
				}
				
				System.out.println(sb);
	}

}
