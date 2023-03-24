/**
 * 
 */
package projects.Guess_a_Number_Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author logan
 * 
 * A game to guess random number, it will show the correct number with same position as (c), 
 * number presents but position different as (p), wrong number as (x).
 */
public class GuessTheNumber_Game 
{	
	Scanner sc;
	int random_arr[]; //= {1,2,2,1};
	int user_arr[];
	int count_random[];
	int count_user[];
	public static int range;
	String random_number;
	int toview;
	
	public void toGetRandom_Number()
	{
		/* 
		 * For guess the number with different range that can user guess. The user can select digit range of a number to guess.
		 * Here i used Random class's nextInt(int bound) method to generate random number, 
		 * this will generate random number upon the bound range.
		 * Every time the random class's method called it will generate single number, 
		 * so i have called the method in for loop, it will generate number depends upon the range of digit that user gives.
		 * I have stored the random number that generates each time in an array to check with user given number on later.
		 * I have also stored the random number in String to use that anywhere without loop, bcauz random number stored in array.
		 * At last i have called toCount_Random() method to count the appearance of random numbers and 
		 * stored in an count_random[] array, to check the user given number's appearance on later. 
		 * */
		
		sc=new Scanner(System.in);
		System.out.println("Enter the digit range of number that you want to guess:");
		try 
		{
			range=sc.nextInt();
			
			if(range<=0)
			{
				throw new GuessNumberException(Error_msg_GuessNumber.err5_range_low_0);
			}
			if(range>10)
			{
				throw new GuessNumberException(Error_msg_GuessNumber.err4_range_restrict);
			}
			
			Random r=new Random();
			random_arr=new int[range];
			random_number="";				
			
			for(int i=0;i<range;i++)
			{
				random_arr[i]=r.nextInt(9);		
				random_number+=random_arr[i];
			}
			
			/* !$ user notice to test: $!
			 * if any one want to test their number please comment above all upto range=sc.nextInt and 
			 * give your value in instancely created int random_arr[] above this method like int random_arr[]={1,2,3,4}
			 * and use below range, for loop to display random number. Also comment GuessNumberException catch block.
			 * Lastly it'll print null don't take that, it is just i stored the random number in a string above so after commenting 
			 * it has no value, so it prints default null. */

							range=random_arr.length;		
							for(int i:random_arr)
								System.out.print(i+" ");
			
			toCount_Random();
		}
		catch(InputMismatchException e)
		{
			e=new InputMismatchException(Error_msg_GuessNumber.err2_input_mismatch);
			System.out.println(e.getMessage());
			toGetRandom_Number();
		}
		catch (GuessNumberException e) 
		{
			System.out.println(e.getMessage());
			toGetRandom_Number();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	public void toGetUser_Number()
	{
		/* The user will give the number to guess and it will be stored as string,
		 * because java doesn't consider 0 if a number starts with 0 in integer, 
		 * and handled exception that if user gives character it displays some message.
		 * The number in a string will be stored in an array to check with random number, 
		 * if user gives number less than range then it will display some message.
		 * To store number in array, i need to directly store each number in array than to store in integer variable, 
		 * Because if number starts with 0, integer won't consider 0.
		 * For that i have taken string as char by charAt and stored in integer variable, 
		 * now the ASCII value of char will be stored in integer so it'll take 0. 
		 * Now i stored that ASCII number - 48 (number starts with 48 in ASCII, so for 48 (0)-48 : 0 ) and stored in array,   
		 * For e.g user given number in string ->123 => ASCII : 49,50,51; a[0]=49-48 : 1, a[1]=50-48: 2, a[2]=51-48 : 3.
		 * Here i called toGuessNumber() method to check random number with user giving number.  
		 *   */
		
		sc=new Scanner(System.in);
		
		System.out.println("\nEnter number to guess: ");
		try{
			
			String str=sc.nextLine();
			
			for(int i=0;i<str.length();i++)
			{
				if(!(str.charAt(i)>='0' && str.charAt(i)<='9'))
					throw new GuessNumberException(Error_msg_GuessNumber.err2_input_mismatch);
			}
			
			user_arr=new int[range];
			
			if(str.length()!=range)
			{
				
				throw new GuessNumberException(Error_msg_GuessNumber.err1_range_mismatch);
			}
	
			for(int i=0;i<str.length();i++)
			{
				int temp=str.charAt(i);
				user_arr[i]=temp-48;
			}
			
			System.out.println();
			for(int i:user_arr)
				System.out.print(i+" ");
			
			toGuessNumber();
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e=new ArrayIndexOutOfBoundsException(Error_msg_GuessNumber.err1_range_mismatch);
			System.out.println(e.getMessage());
			toGetUser_Number();
		} 
		catch (GuessNumberException e) 
		{
			System.out.println(e.getMessage());
			toGetUser_Number();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());	
		}		
	}
	
  public void toGuessNumber()
	{
		/* First i have taken char array, to mark the characters (c,x,p ) 
		 * i.e. whether the number is correct or wrong and correct position or wrong position. 
		 * Initially i have checked the user given number with random number on position or index based, 
		 * for e.g => random number = 1212 , user given number = 1111 , 
		 * i'll check user given number's first position with random number's first position and 
		 * next user given number's second position with random number's second position and it goes....
		 * and i have used variable(check) to count, i.e if both the number are in same position and correct 
		 * then it'll increase its value by 1, and i have also counted the user given number in count_user array.
		 * so atlast if check is equal to range(random number's digit) then all numbers user given is correct, so it'll end there.
		 * if not, then it enter into else block where i given if the current index has character = 'c' then it will move to next number.
		 * Because i have already checked correct number with same position and i have the count of occurrence of user given number.
		 * now i have to check whether the number presents but with different position or not presents.
		 * for that i compare the user given number's occurrence that doesn't have character ='c' with the user given number's 
		 * occurrence in random number, if the user given number's occurrence count greater then the number not presents otherwise 
		 * the number presents but in different position.
		 * For e.g => random number = 1212 , user given number = 1111, after first logic (c, ,c, ) 1st and 3rd position and number are same 
		 * so it marked as 'c' and count of occurrence are added, count of occurrence of 1 (2).
		 * other's aren't same so it doen't marked, to check if the number presents in different position or not presents.
		 * so in 2nd logic 1st position and 3rd position number willn't enter 2nd number will enter and counts the occurrence of that number
		 * and after it compares now user number occurrence is (3) which is greater than random number's occurrence of 1 (2)
		 * so it will mark as 'x'.If no user given number presents in random number then it'll return counts as 0. 
		 * if occurrence count is lesser then the number presents but in different position, so it'll mark as 'p'.
		 */
	  
		char ch[]=new char[range];
		int check=0;
		count_user=new int[range];
		
		for(int i=0;i<user_arr.length;i++)
		{
			if(user_arr[i]==random_arr[i])
				{
					ch[i]='c';
					check++;
					toUser_Count(user_arr[i]);
				}
		}
		
		if(check==range)
		{
			{
				System.out.println();
				for(char i:ch)
					System.out.print(i+" ");
			}
			System.out.println("\n\nCongratulations, You have guessed correctly. \n\nThe number is : "+random_number );
		}
		else
		{
			for(int i=0;i<user_arr.length;i++)
			{	
				if(ch[i]!='c') 
				{
						toUser_Count(user_arr[i]);
						
						if(toFindcount(user_arr[i],user_arr,count_user) > toFindcount(user_arr[i],random_arr,count_random))
						{
							ch[i]='x';
						}
						else
						{
							ch[i]='p';
						}	
				}
			}
			
				System.out.println();
				for(char i:ch)
					System.out.print(i+" ");
				
				System.out.println();
				toview++;
				if(toview%10==0)
				{
					System.out.println("\n\nDo you want to reveal the number: \n1. Yes \n2. To continue guessing\n");
					toAskUser();
				}
				else
				toGetUser_Number();
		}
		
	}
  
  public void toCount_Random()
  {
		/*
		 * This method to count the appearance of random number and to store in an array.
		 * If no number repeats then the count will be stored in respective index. 
		 * If any number repeats then, the count will be stored in first repeated number's index 
		 * then the repeated number's index will have 0.
		 * As I started j as i index, because it doesn't need to start from first as first comer's will check all the next places.
		 * After first outer loop executes then it will check if the same number already came till before of that number, 
		 * if it came then that index will have 0 and it will not enter inner loop, to avoid the count collision.
		 * For e.g => {1,2,1,1} -> 1 - count[0] : 3, 2 - count[1] : 1 ; 
		 * if that while not given then the third place 1 will enter into inner loop and next number also 1, 
		 * so it increases it's count as count[3] : 1.
		 * As I don't want that to happen because later i'll check user number's appearance with this counts.
		 */
	  count_random=new int[range];
		
		for(int i=0;i<random_arr.length;i++)
		{
			int index=0,j=i;
			while(index<i)
			{
				if(random_arr[i]==random_arr[index])
				{
					count_random[i]=0;
					j=random_arr.length;
				}
				index++;
			}
			
			for(;j<random_arr.length;j++)
			{
				if(random_arr[i]==random_arr[j])
				{
					count_random[i]+=1;
				}
			}
		}
  }
  
  private void toUser_Count(int num) {
		/*
		 * It will count the occurrence of user given number in an array, if any repeats then 
		 * the count will be added in the first repeated position. 
		 * */
		  for(int i=0;i<user_arr.length;i++)
		  {
			  if(num==user_arr[i])
			  {
				  count_user[i]+=1;
				  break;
			  }
			  
		  }
	}
  
  private int toFindcount(int num,int[] arr, int[] count_arr) {
		/* It will give the count of occurrence of a number, the repeated occurrence are added in first repeated position, 
		 * so it'll return the count of that position, if number not presents then it'll return 0. */
		  int i=0;
		  for(;i<arr.length;i++)
		  {
			  if(num==arr[i])
				  return count_arr[i];
		  }
		return 0;
	}
  
  public void toAskUser()
  {
		try 
		{
			sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("This is the random number : "+random_number+" \nGood try, see you again.");
					break;
				case 2:
					toGetUser_Number();
					break;
				default:
					throw new GuessNumberException(Error_msg_GuessNumber.err3_choice_mismatch);
			}
		}
		catch(InputMismatchException e)
		{
			e=new InputMismatchException(Error_msg_GuessNumber.err2_input_mismatch);
			System.out.println(e.getMessage());
			toAskUser();
		}
		catch(GuessNumberException e)
		{
			System.out.println(e.getMessage());
			toAskUser();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
  }
	
	public static void main(String[] args) 
	{
		System.out.println("\n\n c - correct number and correct position \n p - correct number but position wrong \n x - wrong number\n");
		GuessTheNumber_Game obj=new GuessTheNumber_Game();
		try
		{
			obj.toGetRandom_Number();
			obj.toGetUser_Number();	
		}
		finally {
			obj.sc.close();
		}
	}

}
