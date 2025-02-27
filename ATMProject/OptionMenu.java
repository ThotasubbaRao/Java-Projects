package ATMProject;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class OptionMenu extends Account {
      Scanner MenuInput = new Scanner(System.in);
	  DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");
	  
	  HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
	  
	  public void getLogin() throws IOException{
		  int x =1;
		  
		  do {
			  try {
				  data.put(98989898, 9966);
				  data.put(89898989, 9999);
				  
				  System.out.println("Welcome to the ATM Project!");
				  
				  System.out.print("Enter Your Customer Number : ");
				  setCustomerNumber(MenuInput.nextInt());
				  
				  System.out.print("Enter Your Pin Number : ");
				  setPinNumber(MenuInput.nextInt());
				  
			  }catch(Exception e) {
				  System.out.println("\n"+"Invalid character(s). Only numbers."+"\n");
				  x =2;
			  }
			  for(Map.Entry<Integer,Integer> entry: data.entrySet()) {
				  if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber()) {
					  getAccountType();
				  }
			  }
			  System.out.println("\n"+ "Wrong Customer Number or Pin Number."+"\n");
		  }while(x==1);
	  }
	  
	  public void getAccountType() {
		  System.out.println("Select the Account you want to access: ");
		  System.out.println("Type 1 - Checking Account");
		  System.out.println("Type 2 - Saving Account");
		  System.out.println("Type 3 - Exit");
		  System.out.println("Choice : ");
		  
		  selection = MenuInput.nextInt();
		  
		  switch(selection) {
		      case 1 :
		    	  getChecking();
		    	  break;
		      case 2 :
		    	  getSaving();
		    	  break;
		      case 3 :
		    	  System.out.println("Thank you for using this ATM, bye.");
		    	  break;
		      default : 
		    	  System.out.println("\n"+"Invalid Choice."+"\n");
		    	  getAccountType();
		  }
	  }
	  
	  public void getChecking() {
		  System.out.println("Checking Account : ");
		  System.out.println("Type 1 - View Balance");
		  System.out.println("Type 2 - Withdraw Funds");
		  System.out.println("Type 3 - Deposit Funds");
		  System.out.println("Type 4 - Exit");
		  System.out.print("Choice : ");
		  
		  selection = MenuInput.nextInt();
		  
		  switch(selection) {
		  case 1 :
			  System.out.println("Checking Account Balance: "+ moneyformat.format(getCheckingBalance()));
			  getAccountType();
			  break;
		  case 2 : 
			  getCheckingWithdrawInput();
			  getAccountType();
			  break;
		  case 3 :
			  getCheckingDepositInput();
			  getAccountType();
			  break;
		  case 4 :
			  System.out.println("Thank you for using This ATM, bye.");
			  break;
		  default:
			  System.out.println("\n"+"Invalid choice."+"\n");
			  getChecking();
		  }
		  
	  }
	  
	  public void getSaving() {
		  System.out.println("Saving Account: ");
		  System.out.println("Type 1 - View Balance");
		  System.out.println("Type 2 - Withdraw Funds");
		  System.out.println("Type 3 - Deposit Funds");
		  System.out.println("Type 4 - Exit");
		  System.out.print("Choice : ");
		  
		  selection = MenuInput.nextInt();
		  
		  switch(selection) {
		  case 1:
			  System.out.println("Saving Account Balance: "+moneyformat.format(getSavingBalance()));
			  getAccountType();
			  break;
		  
		  case 2:
			  getSavingWithdrawInput();
			  getAccountType();
			  break;
		   
		  case 3:
			  getSavingDepositInput();
			  getAccountType();
			  break;
		  case 4:
			  System.out.println("Thank You for Using this ATM,bye.");
			  break;
		  default:
			  System.out.println("\n"+"Invalid choice."+"\n");
			  getSaving();
	  }
   }
   int selection;
}
