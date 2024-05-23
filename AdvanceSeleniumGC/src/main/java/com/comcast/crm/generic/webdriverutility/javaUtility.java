  package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {
public int getRandomNumber() {
	Random r=new Random();
	int res=r.nextInt(5000);
	return res;
}
public String getSystemDate_YYYYMMDD(){
	Date dateobj=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-DD");
	String date=sim.format(dateobj);
	return date;
}
public String getRequiredDate(int days) {
	SimpleDateFormat sim= new SimpleDateFormat("YYYY-MM-DD");
	 Calendar cal = sim.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH, days);
	 String reqDate=sim.format(cal.getTime());
	 return reqDate;
}
}
