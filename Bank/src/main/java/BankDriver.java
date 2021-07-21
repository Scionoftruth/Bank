import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.TransactionDao;
import com.bank.dao.TransactionDaoDB;
import com.bank.dao.UserDao;
import com.bank.dao.UserDaoDB;
import com.bank.exceptions.AccountDoesNotExistException;
import com.bank.models.Account;
//import com.bank.models.Account;
import com.bank.models.AccountDisplay;
import com.bank.models.TransactionDisplay;
import com.bank.models.User;
import com.bank.services.AccountService;
import com.bank.services.TransactionService;
//import com.bank.models.AccessLevel;
import com.bank.services.UserService;

public class BankDriver {
	
	private static UserDao uDao = new UserDaoDB();
	private static AccountDao aDao = new AccountDaoDB();
	private static TransactionDao tDao = new TransactionDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static AccountService aServ = new AccountService(aDao);
	private static TransactionService tServ = new TransactionService(tDao);
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		
		boolean done = false;
		
		User u = null;
		
		while(!done) {
			if(u==null) {
				System.out.println("Welcome To The Bank");
				System.out.println("Login or Signup? Press 1 to Login, Press 2 to Signup");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.print("Please Enter Your Username: ");
					String username = in.nextLine();
					System.out.print("Please Enter Your Password: ");
					String password = in.nextLine();
					try {
						u = uServ.signIn(username, password);
						System.out.println(u.getUsername()+" You Are Now Logged In");
					}catch(Exception e) {
						System.out.println("Username or Password Was Incorrect. Goodbye");
						done = true;
					}
				}else{
					System.out.print("Please Enter Your First Name: ");
					String first = in.nextLine();
					System.out.print("Please Enter Your Last Name: ");
					String last = in.nextLine();
					System.out.print("Please Enter Your Username: ");
					String username = in.nextLine();
					System.out.print("Please Enter Your Email: ");
					String email = in.nextLine();
					System.out.print("Please Enter a Password: ");
					String password = in.nextLine();
					//AccessLevel access = CUSTOMER;
					try {
						u = uServ.signUp(first, last, username, email, password, "customer");
						System.out.println("You May Now Login With the Username: " + u.getUsername());
						done = true;
					}catch(Exception e) {
						System.out.println("Sorry, We Could Not Process Your Request");
						System.out.println("Please Try Again Later");
						done = true;
					}
				}
			}else{
				 if(u.getAccess().equals("employee")){
				 		int eselect = 0;		
				 		while(eselect!=4){
				  			System.out.println("Please Select an Option");
				  			System.out.println("1: View Customer Account");
				  			System.out.println("2: Approve or Reject");
				  			System.out.println("3: View Transactions Log");
				  			System.out.println("4: Logout");
				  			eselect=Integer.parseInt(in.nextLine());
				  			switch(eselect){
				  				case 1:{//Lookup Customer Account
				  					System.out.println("Please Enter Customer Username");
				  					System.out.print("Username: ");
				  					String cust = in.nextLine();
				  					List<AccountDisplay> eaccounts = aServ.getAllAccounts();
				  					for(AccountDisplay eaccount : eaccounts) {
				  						if(!eaccount.getUsername().contains(cust)) {
				  							throw new AccountDoesNotExistException();
				  						}else if(eaccount.getUsername().equals(cust)){
				  							System.out.println(eaccount.toString());
				  						}
				  					}
				  					break;
				  				}
				  				case 2:{//Approve or Reject Accounts
				  					System.out.println("Here Is A List Of Accounts For Approval");
				  					List<AccountDisplay> aaccounts = aServ.getAllAccounts();
				  					for(AccountDisplay aaccount : aaccounts) {
				  						if(aaccount.getApproved().equals("pending")) {
				  							System.out.println("Pending Account");
				  							System.out.println(aaccount.toString());
				  							System.out.println("Would You Like to Approve or Reject");
				  							System.out.println("Press 1 To Approve or 2 To Reject");
				  							int input = Integer.parseInt(in.nextLine());
				  							if(input==1) {
				  								aaccount.setApproved("approved");
				  								System.out.println(aaccount.getAccountId());
				  								System.out.println(aaccount.getBalance());
				  								System.out.println(aaccount.getApproved());
				  								aServ.updateAccountApproval(aaccount.getAccountId(), aaccount.getBalance(), aaccount.getApproved());
				  								continue;
				  							}else if(input==2){
				  								aServ.deleteAccount(aaccount.getAccountId());
				  								continue;
				  							}else {
				  								System.out.println("Please Choose 1 or 2");
				  							}
				  						}
				  					}
				  					break;
				  				}
				  				case 3:{//View Transactions Log
				  					try {
				  						BufferedReader br = new BufferedReader(new FileReader("src/log.txt"));
				  						for(String line = br.readLine(); line != null; line = br.readLine()) {
				  							if(line.contains("Transaction")) {
				  								System.out.println(line);
				  							}
				  						}
				  						br.close();
				  					}catch(FileNotFoundException e) {
				  						e.printStackTrace();
				  					}catch(IOException e) {
				  						e.printStackTrace();
				  					}
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
				  		int achoice = Integer.parseInt(in.nextLine());
				  		//System.out.println(u.getUsername());
				  		//System.out.println(aServ.getAllAccounts());
				  		if(achoice==1){
				  			List<AccountDisplay> accounts = aServ.getAllAccounts();
				  			for(AccountDisplay account: accounts) {
				  				if(!account.getUsername().contains(u.getUsername())) {
				  					System.out.println("It Seems Like You Do Not Have An Account With Us");
				  					System.out.println("To Create An Account Press 1, To Exit Press 2");
				  					achoice = Integer.parseInt(in.nextLine());
				  					if(achoice==1) {
				  						System.out.println("Thank You "+ u.getUsername()+" For Creating An Account");
				  						System.out.print("What Would Your Starting Balance Be: ");
				  						int balance = Integer.parseInt(in.nextLine());
				  						aServ.addAccount(u.getId(), balance, "pending");
				  						System.out.println("Congratulations "+u.getUsername()+" Your Account Was Created!");
				  						System.out.println("Are You Finished? Press 1 for Yes, Press 2 for No");
				  						achoice = Integer.parseInt(in.nextLine());
				  						done = (achoice == 1) ? true : false;
				  					}else if(achoice==2) {
				  						done = true;
				  					}
				  				}else if(account.getUsername().equals(u.getUsername())){
				  					System.out.println(account.toString());
				  					AccountDisplay curr = account;
				  					//System.out.println(curr.toString());
				  					if(curr.getApproved().equals("approved")) {
				  					int select = 0;
				  					while(select != 5) {
				  						System.out.println("Select One Of The Following");
				  						System.out.println("1: Withdraw From Account");
				  						System.out.println("2: Deposit Into Account");
				  						System.out.println("3. Transfer To Another Account");
				  						System.out.println("4. Accept Incoming Transfer");
				  						System.out.println("5. Quit Current Session");
				  						select = Integer.parseInt(in.nextLine());
				  						switch(select) {
				  							case 1:{
				  							//Withdraw
				  								System.out.println("How Much Would You Like To Withdraw");
				  								int sub = Integer.parseInt(in.nextLine());
				  								if(sub < 0) {
				  									System.out.println("You Cannont Withdraw A Negative Amount");
				  								}
				  								int result = curr.getBalance()-sub;
				  								if (result < 0) {
				  									System.out.println("You Cannot Withdraw More Than You Have");
				  								}else {
				  									curr.setBalance(result);
				  									aServ.updateAccount(curr.getCustomerId(),curr.getBalance(),curr.getApproved());
				  								}
				  								System.out.println(curr.toString());
				  								break;
				  							}
				  							case 2:{
				  								//Deposit
				  								System.out.println("How Much Would You Like To Deposit");
				  								int add = Integer.parseInt(in.nextLine());
				  								if(add < 0) {
				  									System.out.println("You Cannont Deposit A Negative Amount");
				  								}
				  								int result = curr.getBalance()+add;
				  								curr.setBalance(result);
				  								aServ.updateAccount(curr.getCustomerId(),curr.getBalance(),curr.getApproved());
				  								System.out.println(curr.toString());
				  								break;
				  							}
				  							case 3:{
				  								//Create Transfer
				  								System.out.println("To Create Transfer Press 1, To Exit Press 2");
				  						  		int tchoice = Integer.parseInt(in.nextLine());
				  						  		if(tchoice==1) {
				  						  			System.out.print("What Account Number Would You Like To Transfer To?: ");
				  						  			int recieve = Integer.parseInt(in.nextLine());
				  						  			System.out.print("How Much Would You Like To Transfer?: ");
				  						  			int amount = Integer.parseInt(in.nextLine());
				  						  			if(amount > curr.getBalance()) {
				  						  				System.out.println("You Do Not Have Enough Money For That Transaction!");
				  						  				break;
				  						  			}else {
				  						  				tServ.addTransaction(curr.getAccountId(), recieve, amount);
				  						  				System.out.println("Your Transaction With "+recieve+" For: $"+amount+", Was Created!");
				  						  				System.out.println(curr.toString());
				  						  				break;
				  						  			}
				  						  		}else {
				  						  			break;
				  						  		}
				  								//break;
				  							}
				  							case 4:{
				  								//Incoming Transfers
				  								System.out.println("Printing Pending Transactions");
				  								List<TransactionDisplay> trans = tServ.getAllTransactions();
				  								for(TransactionDisplay tran: trans) {
				  									if(tran.getRecieverId()==curr.getAccountId()) {
				  										System.out.println("Current Transaction");
				  										System.out.println(tran.toString());
				  										System.out.println("Press 1 to Accept or 2 To Reject");
				  										int pchoice = Integer.parseInt(in.nextLine());
				  										if(pchoice==1) {
				  											tServ.acceptTransaction(tran);
				  											System.out.println("Transaction Accepted");
				  											System.out.println(curr.toString());
				  											continue;
				  										}else {
				  											tServ.rejectTransaction(tran);
				  											System.out.println("Transaction Rejected");
				  											System.out.println(curr.toString());
				  											continue;
				  										}
				  									}else {
				  										System.out.println("You Have No Pending Transactions");
				  										break;
				  									}
				  								}
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
				  				}else{
				  					System.out.println("Please Wait For Your Account To Be Approved By An Employee");
				  					done=true;
				  					}
				  				}
				  			}
				  		}else {
				  			done=true;
				  		}
				  }
			}
		}
		System.out.println("Thank You For Choosing Bank");
		in.close();
	}
	/*
	public void withdrawAccount(AccountDisplay a) {
		System.out.println("How Much Would You Like To Withdraw");
		int sub = Integer.parseInt(in.nextLine());
		int result = a.getBalance()-sub;
		if (result < 0) {
			System.out.println("You Cannot Withdraw More Than You Have");
		}else {
			aServ.updateAccount(a.getCustomerId(),result);
		}
	}*/

}
