package com.tyss.GenericUtilities;


import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	
	public int getrandomNumber()
	{
	Random random=new Random();
	int randNum=random.nextInt();
	return randNum;
	}

	
	public String getStringofDateTime()
	{
		Date date=new Date();
		return date.toString();
	}
	
	
	public String getDateFormat()
	{
		Date datte=new Date();
		String datetime=datte.toString();
		String[] dateArray=datetime.split(" ");
		
		int month=datte.getMonth();
		String date=dateArray[2];
		String year=dateArray[5];
		int day=datte.getDay();
		String time=dateArray[3];
		String finalFormat=month+" "+date+" "+year+" "+day+" "+time;
		return finalFormat;
	}


	public String getRandonNumber(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
