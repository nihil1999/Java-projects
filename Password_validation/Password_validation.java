/**
 * 
 */
package projects.Password_validation;

import java.util.Scanner;

/**
 * @author logan
 *
 */
public class Password_validation {

	/**
	 * @param args
	 */
	
	Scanner sc;
	
	
	public void toValidate_Password()
	{
		sc=new Scanner(System.in);
		System.out.println();
		System.out.println("Enter password:");
		String pwd=sc.nextLine();
		System.out.println(pwd);
		boolean flag1=false,flag2=false,flag3=false,flag4=false;
		
		if(pwd.length()<8) 
		  { 
			System.out.println("\nPassword must have minimum 8 letters.");
			  toValidate_Password();
		  }
		else
		{
			for(int i=0;i<pwd.length();i++)
			{
			  
				if(pwd.charAt(i)>='A' && pwd.charAt(i)<='Z')
					flag1=true;
				else if(pwd.charAt(i)>='a' && pwd.charAt(i)<='z')
					flag2=true;
				else if(pwd.charAt(i)>='0' && pwd.charAt(i)<='9')
					flag3=true;
				else if(pwd.charAt(i)>=32 && pwd.charAt(i)<=47 || pwd.charAt(i)>=58 && pwd.charAt(i)<=64 || pwd.charAt(i)>=91 && pwd.charAt(i)<=96 || pwd.charAt(i)>=123 && pwd.charAt(i)<=126)
					flag4=true;
			}
			if(flag1==true && flag2==true && flag3==true && flag4==true)
			{
				System.out.println("\nPassword is valid.");
				toLogin();
			}
			else if(flag1==false)
			{
					System.out.println("\nPassword must have atleast one capital letter.");
					toValidate_Password();
			}
			else if(flag2==false)
			{
				System.out.println("\nPassword must have atleast one lowercase letter.");
				toValidate_Password();
			}
			else if(flag3==false)
			{
				System.out.println("\nPassword must have atleast one number.");
				toValidate_Password();
			}
			else if(flag4==false)
			{
				System.out.println("\nPassword must have atleast one special character.");
				toValidate_Password();
			}
		}
	
}
	
	private void toLogin() {
		// TODO Auto-generated method stub
		System.out.println("\nWelcome to google");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Password_validation obj=new Password_validation();
		obj.toValidate_Password();
	}

}
