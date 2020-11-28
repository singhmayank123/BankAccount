import java.util.Scanner;
import java.util.Random;

public class BankAccount{

	private String depositor_name;
	private String depositor_Address;
	private String accountType;
	private double balance;
	private String accNumber;
	private static int offset = 1000;
	public static int transCounts = 0 ;  

	public BankAccount(){

	}

	public BankAccount(String depositor_name, String depositor_Address, String accountType
	 ,double balance ){

		this.depositor_name = depositor_name;
		this.depositor_Address = depositor_Address;
		this.accountType = accountType;
		this.balance = balance;

	}

	public void generatorAccNumber(){

         accNumber = "BA"+ offset ;
         offset++;

         System.out.println("Account Number Generated successfully....!!\n");

	}

	void showInfo(){

		System.out.println("\ndepositor's name: " + depositor_name);
		System.out.println("depositor's Address: " + depositor_Address);
		System.out.println("AccountType: " + accountType);
		System.out.println("Account Number: " + accNumber);
		System.out.println("Balance Amount: " + balance);

	}

	void deposit(double amount){
		balance += amount;
	}

	void withDraw(double amount){
		balance -= amount;
	}

	void changeAddr( String addr){
		depositor_Address = addr;
	}

	static int randomAccount(int depositorCount){

		 Random rand = new Random(); 
		return rand.nextInt(depositorCount)+1; //randomly select Banks account from 1 to depositorCount
			

	}

	public static void main(String[] args) {


            String res = "";

            int amount , option , randomAcc = 1;

           
		    
            Scanner sc = new Scanner(System.in); 

		    System.out.print("\nEnter No. of depositors you want to Create....!! ");
            int depositorCount = sc.nextInt(); 

            BankAccount depositors[] = new BankAccount[depositorCount] ;

            for (int i = 0 ; i<depositorCount ; i++ ) {
			
            sc.nextLine();

			System.out.print("\n\nEnter Depositor"+(i+1)+" Name: "); 
			String name = sc.nextLine();

			System.out.print("Enter Depositor"+(i+1)+" Address: "); 
			String addr = sc.nextLine() ;

			System.out.print("Enter Depositor"+(i+1)+" AccountType(Saving/Current): "); 
			String accType = sc.nextLine() ;  // Create a Scanner object

			System.out.print("Enter Depositor"+(i+1)+" Initial Balance: "); 
			double balance = sc.nextDouble() ;

			depositors[i] = new BankAccount(name, addr , accType , balance);
			

		    }
			 
			System.out.println("\nRecords Created successfully....!!\n");

            
            do{


			System.out.println("\n************** User's Information *******************\n");

			System.out.println("1) Generate Account Number");
			System.out.println("2) Show your Info");
			System.out.println("3) Deposit Amount");
			System.out.println("4) Withdraw Amount");
			System.out.println("5) Change Address");
			System.out.println("5) Exit");

			System.out.print("Choose Any Option (1 to 5): ");

		    option = sc.nextInt();

		    if(option == 5) break ;

			System.out.println("\n\nHey !! There are "+depositorCount + " Bank Accounts in this Bank !!");
			System.out.print("\nBankAccount"+randomAcc+" is already selected !! \n\n");
			System.out.print("Do you Want to Select another Account randomly(y/n) ?? ");
            
            res = sc.next();

            if(res.equals("y")){

				randomAcc = randomAccount(depositorCount);
				System.out.print("\nBankAccount"+randomAcc+" has been selected randomly...!!\n ");

			}


			if( option == 1) depositors[randomAcc-1].generatorAccNumber();
		    
		    else if(option == 2) depositors[randomAcc-1].showInfo();
					
			else if(option == 3){
		
				    System.out.print("\nEnter Your Amount to Deposit : ");
				    amount = sc.nextInt();
					depositors[randomAcc-1].deposit(amount);

					transCounts++;
					
				}
			else if(option == 4){
				
				    System.out.print("\nEnter Your Amount to Withdraw : ");
				    amount = sc.nextInt();
					depositors[randomAcc-1].withDraw(amount);

					transCounts++;
					
			}

            else{

            	System.out.println("\nInvalid Option !! Choose Correct One ");
            }
     
            System.out.println(option != 5);

			} while(true) ;


			System.out.println("\nTotal No. of Trasactions for all the depositors = " + transCounts) ;

	}
}