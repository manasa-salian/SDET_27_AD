package com.crm.autodesk.genericutility;

import java.util.Date;

import java.util.Random;
/**
 * 
 * @author Manasa
 *
 */
public class JavaUtility { 
	/**
	 * used to generate random number
	 * @return
	 */
	
	 public int getRanDomNumber() {
	Random rand=new Random();
	 int randNum=rand.nextInt(1000);
	 return randNum;

}  
	 /**
	  * used to get system date and time
	  * @return
	  */
	 
	 
	 public String getSystemDateAndTime() {
		Date date =new Date();
		return date.toString();
		 
	 }
	 /**
	  * used to generate date and time in format
	  * @return
	  */
	 public String getSystemDateWithFormat() {
		 Date date=new Date();
		 String dateAndTime = date.toString();
		 
		 String YYYY=dateAndTime.split("")[5];
		 String DD=dateAndTime.split("")[2];
		 int MM=date.getMonth()+1;
		  String finalFormat=YYYY+"-"+DD+"-"+MM;
		  return finalFormat;
	 }

		 
	 
	 
}
