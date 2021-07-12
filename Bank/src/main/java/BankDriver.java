import java.util.List;
import java.util.Scanner;

import com.bank.exceptions.AccountDoesNotExistException;
import com.bank.models.Account;
import com.bank.models.User;
import com.bank.services.AccountService;
//import com.bank.models.AccessLevel;
import com.bank.services.UserService;

public class BankDriver {
	
	private static UserService uServ  = new UserService("users.txt");
	
	private static AccountService aServ = new AccountService("accounts.txt");

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		
		User u = null;
		
		while(!done) {
			if(u==null) {
				System.out.println("Login or Signup? Press 1 to Login");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.println("Please Enter Your Username: ");
					String username = in.nextLine();
					System.out.println("Please Enter Your Password: ");
					String password = in.nextLine();
					try {
						u = uServ.login(username, password);
					}catch(Exception e) {
						System.out.println("Username or Password Was Incorrect. Goodbye");
						done = true;
					}
				}else {
					System.out.print("Please Enter Your First Name");
					String first = in.nextLine();
					System.out.print("Please Enter Your Last Name");
					String last = in.nextLine();
					System.out.print("Please Enter Your Username");
					String username = in.nextLine();
					System.out.print("Please Enter a Password");
					String password = in.nextLine();
					//AccessLevel access = CUSTOMER;
					try {
						u = uServ.signUp(first, last, username, password, "customer");
						
						System.out.println("You May Now Login With the Username: " + u.getUsername());
					}catch(Exception e) {
						System.out.println("Sorry, We Could Not Process Your Request");
						System.out.println("Please Try Again Later");
						done = true;
					}
				}
			}else{
				 if(u.getAccess().equals("employee")){
				 		int eselect = Integer.parseInt(in.nextLine());		
				 		while(eselect!=4){
				  			System.out.println("Please Select an Option");
				  			System.out.println("1: View Customer Account");
				  			System.out.println("2: Approve or Reject");
				  			System.out.println("3: View Transactions Log");
				  			System.out.println("4: Logout");
				  			switch(eselect){
				  				case 1:{//Lookup Customer Account
				  					System.out.println("Please Enter Customer Username");
				  					System.out.print("Username: ");
				  					String cust = in.nextLine();
				  					List<Account> eaccounts = aServ.getAllAccounts();
				  					for(Account eaccount : eaccounts) {
				  						if(!eaccount.getUser().contains(cust)) {
				  							throw new AccountDoesNotExistException();
				  						}else if(eaccount.getUser().equals(cust)){
				  							System.out.println(eaccount.toString());
				  						}
				  					}
				  					break;
				  				}
				  				case 2:{//Approve or Reject Accounts
				  					
				  					break;
				  				}
				  				case 3:{//View Transactions Log
				  					
				  					break;
				  				}
				  				case 4:{
				  					done=true;
				  					break;
				  				}
				  				default:{
				  					System.out.println("Please Pick a Number From The List");
				  					break;
				  				}
				  			}
				 		}
				  }else{
				  		System.out.println("To View Account Press 1, To Exit Press 2");
				  		int choice = Integer.parseInt(in.nextLine());
				  		if(choice==1){
				  			List<Account> accounts = aServ.getAllAccounts();
				  			for(Account account: accounts) {
				  				if(!account.getUser().contains(u.getUsername())) {
				  					System.out.println("It Seems Like You Do Not Have An Account With Us");
				  					System.out.println("To Create An Account Press 1, To Exit Press 2");
				  					if(choice==1) {
				  						System.out.println("Thank You "+ u.getUsername()+" For Creating An Account");
				  						System.out.print("What Would Your Starting Balance Be: ");
				  						int balance = Integer.parseInt(in.nextLine());
				  						Account a = new Account(u.getUsername(), balance);
				  						aServ.addAccount(a);
				  						System.out.println("Congratulations "+u.getUsername()+" Your Account Was Created!");
				  						System.out.println("Are You Finished? Press 1 for Yes, Press 2 for No");
				  						choice = Integer.parseInt(in.nextLine());
				  						done = (choice == 1) ? true : false;
				  					}
				  				}else if(account.getUser().equals(u.getUsername())){
				  					System.out.println(account.toString());
							
				  					int select = Integer.parseInt(in.nextLine());
				  					while(select != 5) {
				  						System.out.println("Select One Of The Following");
				  						System.out.println("1: Withdraw From Account");
				  						System.out.println("2: Deposit Into Account");
				  						System.out.println("3. Transfer To Another Account");
				  						System.out.println("4. Accept Incoming Transfer");
				  						System.out.println("5. Quit Current Session");
				  						switch(select) {
				  							case 1:{
				  							//Withdraw
				  								
				  								break;
				  							}
				  							case 2:{
				  								//Deposit
				  								
				  								break;
				  							}
				  							case 3:{
				  								//Transfer
				  								
				  								break;
				  							}
				  							case 4:{
				  								//Accept Transfer
				  								
				  								break;
				  							}
				  							case 5:{
				  								done=true;
				  								break;
				  							}
				  							default:{
				  								System.out.println("Please Select a Number From the List");
				  								break;
				  							}
				  						}
				  					}
				  				}
				  			}
				  		}	
				  }
			}
		}
		System.out.println("Thank You For Choosing Bank");
		in.close();
	}

}
