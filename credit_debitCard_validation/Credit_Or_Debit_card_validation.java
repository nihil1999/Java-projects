/**
 * 
 */
package projects.credit_debitCard_validation;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author logan
 * 
 *to check the credit/debit card type and is it valid or not by Luhn's algorithm.
 *In your card number, take from right side multiply by 2 on every other digit i.e starting at second digit from right side and 
 *after multiply if any digit is two digit then sum the digits, after add all the numbers. If sum % 10 is 0 then that card is valid otherwise it is not valid.
 *for e.g => 4624 7482 3324 9080 : 8*2 = 16, 9*2 = 18, 2*2 = 4, 3*2 = 6, 8*2 = 16, 7*2 = 14, 2*2 = 4, 4*2 = 8 ; -> sum of the digits: 14=>5, 16=>7, 18=>9
 *8+6+4+4+5+4+7+2+6+3+4+4+9+0+7+0=73; 73%10!=0 card not valid.
 *card types : American Express, MasterCard,  Visa   , Rupay
 *prefix     : 34, or 37       , 51 - 55   ,   4     , 60, 65, 81, 82, 508
 *length 	 :  15			   ,  16	   ,13 or 16 ,  16
 */

public class Credit_Or_Debit_card_validation {
	
	Scanner sc;
	long num;
	int arr[];
	String cardName;
	boolean flag;
	
	public void toGet_userCardNumber()
	{
		flag=true;
		sc=new Scanner(System.in);
		System.out.println("Enter your credit or debit card number without giving space");
		try 
		{
			num=sc.nextLong();
			
			int card_length=toCheckLength(num);
			if(card_length>16)
			{
				throw new CreditCardException(CreditCardException.err1_cardRange_mismatch);
			}
			else if(card_length<=0)
			{
				throw new CreditCardException(CreditCardException.err2_cardRange0_mismatch);
			}
			else if(card_length>0 && card_length<13 )
			{
				throw new CreditCardException(CreditCardException.err3_cardRange_less);
			}
			
			long temp=num;
			arr=new int[card_length];
			
			for(int i=0;i<arr.length;i++)
			{
				arr[arr.length-i-1]=(int)(temp%10);
				temp/=10;
			}
			
			if(toFind_card(card_length))
			{
				//toDisplay();
				toCheck_card_validation();
			}
			else
			{
				if(flag==true)
				toGet_userCardNumber();
			}
		}
		catch(InputMismatchException e)
		{
			e=new InputMismatchException(CreditCardException.err4_input_mismatch);
			System.out.println(e.getMessage());
			toGet_userCardNumber();
		}
		catch (CreditCardException e) 
		{
			System.out.println(e.getMessage());
			toGet_userCardNumber();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	private boolean toFind_card(int card_length) 
	{
		switch(arr[0])
		{
		case 3:
				if(card_length!=15)
				{
					System.out.println(CreditCardException.err3_cardRange_less);
					return false;
				}
				else
				{
					if(arr[1]==4 || arr[1]==7)
					{
						cardName="American Express";
						return true;
					}
					else
						{
							System.out.println("\nYour Credit/Debit card is not valid");
							flag=false;
							return false;
						}
				}
		case 5:
				if(card_length!=16)
				{
					System.out.println(CreditCardException.err3_cardRange_less);
					return false;
				}
				else 
				{
					if(arr[1]>=1 && arr[1]<=5)
					{
						cardName="MasterCard";
						return true;
					}
					else if(arr[1]==0 && arr[2]==8)
					{
						cardName="Rupay";
						return true;
					}
					else
					{
						System.out.println("\nYour Credit/Debit card is not valid");
						flag=false;
						return false;
					}
				}
		case 4:
				if(card_length!=13 && card_length!=16)
				{
					System.out.println(CreditCardException.err3_cardRange_less);
					return false;
				}
				else 
				{
					cardName="Visa";
					return true;
				}
		case 6:
				if(card_length!=16)
				{
					System.out.println(CreditCardException.err3_cardRange_less);
					return false;
				}
				else
				{
					if(arr[1]==0 || arr[1]==5)
					{
						cardName="Rupay";
						return true;
					}
					else
					{
						System.out.println("\nYour Credit/Debit card is not valid");
						flag=false;
						return false;
					}
						
				}
		case 8:
				if(card_length!=16)
				{
					System.out.println(CreditCardException.err3_cardRange_less);
					return false;
				}
				else
				{
					if(arr[1]==1 || arr[1]==2)
					{
						cardName="Rupay";
						return true;
					}
					else
					{
						System.out.println("\nYour Credit/Debit card is not valid");
						flag=false;
						return false;
					}
						
				}
			
		default:
				System.out.println("\nYour Credit/Debit card is not valid");
				flag=false;
					return false;
		}
	}

	private int toCheckLength(long num2) 
	{
		int count=0;
		while(num2>0)
		{
			num2/=10;
			count++;
		}
		return count;
	}

	public void toCheck_card_validation()
	{
		int total=0;
		for(int i=arr.length-2;i>=0;i-=2)
		{
			arr[i]*=2;
			if(arr[i]>9)
			{
				arr[i]=(arr[i]%10)+(arr[i]/10);
			}
		}
		
		for(int i=0;i<arr.length;i++)
		{
			total+=arr[i];
		}
		
		//toDisplay();
//		System.out.println();
//		System.out.println(total);
		if(total%10==0)
		{
			System.out.println("\nYour Credit/Debit card is "+cardName+" and it is valid");
		}
		else
			System.out.println("\nYour Credit/Debit card is not valid");
	}
	
	
	private void toDisplay() 
	{
		System.out.println();
		for(int i:arr)
			System.out.print(i);
	}

	public static void main(String[] args)
	{
		Credit_Or_Debit_card_validation obj=new Credit_Or_Debit_card_validation();
		obj.toGet_userCardNumber();
	}

}
