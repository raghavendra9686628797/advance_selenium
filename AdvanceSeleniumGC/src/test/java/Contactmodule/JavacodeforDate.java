package Contactmodule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavacodeforDate {
public static void main(String[] args) {
	//to disply system date
	Date d=new Date();
	System.out.println(d);
	
	//change date format  we have to dedlare month in  uppercase only
SimpleDateFormat  s=new SimpleDateFormat("yyyy-MM-dd");
String currentdate=s.format(d);
System.out.println(currentdate);

//to choose date before or after
Calendar cal=s.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,30);
String reqdate=s.format(cal.getTime());
System.out.println(reqdate);
}
}
