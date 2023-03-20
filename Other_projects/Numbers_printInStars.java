/**
 * 
 */
package projects.Other_projects;

import java.util.Scanner;

/**
 * @author logan
 *
 */
public class Numbers_printInStars {

	/**
	 * @param args
	 */
	
	public void to_printNumbers_inStars()
	{
		Scanner sc=new Scanner (System.in);
		int row_length=9;
		int col_length=7;
		int row_mid=row_length/2;
		
		System.out.println("Enter number: ");
		int num=sc.nextInt();
		int num2=num,temp=num;
		int temp1=num,count=0;
		
		while(temp1>0)				//to count the digits.
		{
			temp1/=10;
			count++;
		}
		
		
		if(num==0)
		{
			System.out.println("\n ");
			for(int row=0;row<row_length;row++)			
			{
				for(int col=0;col<col_length;col++)
				{
					if(row==0 || col==0 || row== row_length-1|| col==col_length-1 )
					System.out.print("* ");
					else
						System.out.print("  ");
					
				}
				System.out.println();
			}
		}
		if(num<0)
			{
				System.out.println("Enter valid number");
			}
		
		else {
		while(count>0) 
		{
			
			int index=count-1;
			int temp_count=count-1;
			
			while(index>0)
			{
				temp/=10;
				index--;
			}
			
		switch(temp) {
		
		case 0:
			System.out.println("  ");
		for(int row=0;row<row_length;row++)			
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || col==0 || row== row_length-1|| col==col_length-1 )
				System.out.print("* ");
				else
					System.out.print("  ");
				
			}
			System.out.println();
		}
		break;
		
		case 1:
			System.out.println();
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(col==col_length/2 )
					System.out.print("* ");
				else if(row<row_mid && col==col_length/2-row )
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 2:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || row==row_mid || row==row_length-1)
					System.out.print("* ");
				else if(row<row_mid && col==col_length-1)
					System.out.print("* ");
				else if(row>row_mid && col==0)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		break;
		
		case 3:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || row==row_mid || row==row_length-1 || col==col_length-1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 4:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row<=row_mid && col==col_length-row-3)
					System.out.print("* ");
				else if(row==row_mid+1 || col==col_length-2)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 5:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || row==row_mid || row==row_length-1)
					System.out.print("* ");
				else if(row>row_mid && col==col_length-1)
					System.out.print("* ");
				else if(row<row_mid && col==0)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 6:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || row==row_mid || row==row_length-1 || col==0)
					System.out.print("* ");
				else if(row>row_mid && col==col_length-1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 7:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || col==col_length-1)
					System.out.print("* ");
				else 
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 8:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || row==row_mid || row==row_length-1 || col==0 || col==col_length-1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		case 9:
		System.out.println("\n");
		for(int row=0;row<row_length;row++)
		{
			for(int col=0;col<col_length;col++)
			{
				if(row==0 || row==row_mid || col==col_length-1)
					System.out.print("* ");
				else if(row<row_mid && col==0)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		break;
		
		default:
			System.out.println("Enter valid number ");
		
	}
		int mul=temp;
		while(temp_count>0)
		{
			mul*=10;
			temp_count--;
		}
		temp=num2-mul;
		num2=temp;
		count--;
	}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numbers_printInStars obj=new Numbers_printInStars();
		obj.to_printNumbers_inStars();
	}

}
