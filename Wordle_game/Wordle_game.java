/**
 * 
 */
package projects.Wordle_game;

import java.util.Random;
import java.util.Scanner;

/**
 * @author logan
 *
 */
public class Wordle_game {

	/**
	 * @param args
	 */
	Scanner sc;
	int range;
	String s1;
	String s2;
	int[] count_random_word;
    int[] count_user;
	
	public void toGetRandom_Word()
	{
		s1="malayalam";	
		range=s1.length();
		System.out.println(s1);
		count_randomWord();
	}
	
	public void toGetWord_fromUser()
	{
		sc=new Scanner(System.in);
		System.out.println("Enter word to guess: ");
		s2=sc.nextLine();
		
		toGuessWord();
	}
	
	 public void toGuessWord()
		{
			char ch[]=new char[range];
			int count=0;
			count_user=new int[range];
			for(int i=0;i<s1.length();i++)
			{ 
				if(s1.charAt(i)==s2.charAt(i))
				{
					ch[i]='c';
					count++;
					toUser_Count(s2.charAt(i));
				}
			}
			if(count==range)
			{
				System.out.println(ch);
			}
			else
			{
				for(int i=0;i<s2.length();i++)
				{	
					if(ch[i]!='c') 
					{
							toUser_Count(s2.charAt(i));
							
							if(toFindcount(s2.charAt(i),s2,count_user) > toFindcount(s2.charAt(i),s1,count_random_word))
								ch[i]='x';
							else
								ch[i]='p';
					}
				}
				System.out.println(ch);
				
				System.out.println();
				toGetWord_fromUser();
			}
		}
	 
	 public void count_randomWord()
	 {
		 count_random_word=new int[range];
		 for(int i=0;i<s1.length();i++)
			{
				int index=0,j=i;
				while(index<i)
				{
					if(s1.charAt(i)==s1.charAt(index))
					{
						count_random_word[i]=0;
						j=s1.length();
					}
					index++;
				}
				
				for(;j<s1.length();j++)
				{
					if(s1.charAt(i)==s1.charAt(j))
					{
						count_random_word[i]+=1;
					}
				}
			}
	 }
	 
	  private void toUser_Count(char ch) {
			/*
			 * It will count the occurrence of user given number in an array, if any repeats then 
			 * the count will be added in the first repeated position. 
			 * */
			  for(int i=0;i<s2.length();i++)
			  {
				  if(ch==s2.charAt(i))
				  {
					  count_user[i]+=1;
					  break;
				  }
				  
			  }
		}
	  
	  private int toFindcount(char ch,String s, int[] count_arr) {
			/* It will give the count of occurrence of a number, the repeated occurrence are added in first repeated position, 
			 * so it'll return the count of that position, if number not presents then it'll return 0. */
			  int i=0;
			  for(;i<s.length();i++)
			  {
				  if(ch==s.charAt(i))
					  return count_arr[i];
			  }
			return 0;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wordle_game obj=new Wordle_game();
		obj.toGetRandom_Word();
		obj.toGetWord_fromUser();
	}

}
