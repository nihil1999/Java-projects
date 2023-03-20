/**
 * 
 */
package projects.Other_projects;

import java.util.Scanner;

/**
 * @author logan
 *to predict year, month, day of a given hour.
 */
public class Day_Month_Year_prediction {

	/**
	 * @param args
	 */

//method 1:
	public void toPredict()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter hours: ");
		float number=sc.nextFloat();
		float num=number;
		int sec=0,min=0,hour=0,day=0,month=0,year=0;
		int sec_count=0,min_count=0,hour_count=0,day_count=0,month_count=0;
		
		min_count=(int) (num*60);
		sec_count=(int)(num*60*60);
		hour_count=(int) num;
		
		while(num>0)
		{
			if(num<24)
			{
				hour=(int)num;
				min=(int) ((num-(int)num)*60);
				num-=24;
			}
			while(num>=24)
			{
				day=day+1;
				num-=24;
				day_count=day;
			}
			
			while(day>=30)
			{
				month=month+1;
				day-=30;
				month_count=month;
			}
			
			while(month>=12)
			{
				year+=1;
				month-=12;
			}
		}

			if(year!=0) 
			{
				System.out.println("\n--------------This is to print HOURS in YEARS:----------------- \n");
				System.out.println("Year : "+year+"\nMonth : "+month+"\nDay : "+day+"\nHours : "+hour+"\nMinutes : "+min);
			}
			if(month_count!=0)
			{
				System.out.println("\n--------------This is to print HOURS in MONTHS:---------------- \n");
				System.out.println("Month : "+month_count+"\nDay : "+day+"\nHours : "+hour+"\nMinutes : "+min);
			}
			if(day_count!=0)
			{	
				System.out.println("\n--------------This is to print HOURS in DAYS:------------------\n");
				System.out.println("Day : "+day_count+"\nHours : "+hour+"\nMinutes : "+min);
			}
			if(hour_count!=0)	
			{
				System.out.println("\n--------------This is to print HOURS in HOURS:----------------- \n");
				System.out.println("Hour is: "+hour_count+"\nMinutes is: "+min);
			}
			
			System.out.println("\n--------------This is to print HOURS in MINUTES:------------------- \n");
			System.out.println("Minutes: "+min_count);
			
			System.out.println("\n--------------This is to print HOURS in SECONDS:------------------- \n");
			System.out.println("Seconds: "+sec_count);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day_Month_Year_prediction obj=new Day_Month_Year_prediction();
		//obj.toPredict();
		obj.toPredict_without_using_loop();
	}

//method 2:	
	public void toPredict_without_using_loop()
		{
			System.out.println();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter hours: ");
			float number=sc.nextFloat();
			float num=number;
			int sec=0,min=0,hour=0,day=0,month=0,year=0;
			int sec_count=0,min_count=0,hour_count=0,day_count=0,month_count=0;
			
			min_count=(int) (num*60);
			sec_count=(int)(num*60*60);
			hour_count=(int) num;
			min=(int) ((num-(int)num)*60);
			
			if(num<24)
			{
				hour=(int)num;
				num-=24;
			}
			if(num>=24)
			{
				day=(int)num/24;
				day_count=day;
				hour=(int)num%24;
			}
		
			if(day>=30)
			{
				month=day/30;
				month_count=month;
				day=(int)day%30;
			}
		
			if(month>=12)
			{
				year=month/12;
				month=(int)month%12;
			}
			
			if(year!=0) 
			{
				System.out.println("\n--------------This is to print HOURS in YEARS:-------------- \n");
				System.out.println("Year : "+year+"\nMonth : "+month+"\nDay : "+day+"\nHours : "+hour+"\nMinutes : "+min);
			}
			if(month_count!=0)
			{
				System.out.println("\n--------------This is to print HOURS in MONTHS:-------------- \n");
				System.out.println("Month : "+month_count+"\nDay : "+day+"\nHours : "+hour+"\nMinutes : "+min);
			}
			if(day_count!=0)
			{	
				System.out.println("\n--------------This is to print HOURS in DAYS:-------------- \n");
				System.out.println("Day : "+day_count+"\nHours : "+hour+"\nMinutes : "+min);
			}
			if(hour_count!=0)	
			{
				System.out.println("\n--------------This is to print HOURS in HOURS:-------------- \n");
				System.out.println("Hour is: "+hour_count+"\nMinutes is: "+min);
			}
			
			System.out.println("\n--------------This is to print HOURS in MINUTES:-------------- \n");
			System.out.println("Minutes: "+min_count);
			
			System.out.println("\n--------------This is to print HOURS in SECONDS:-------------- \n");
			System.out.println("Seconds: "+sec_count);
	}

}
