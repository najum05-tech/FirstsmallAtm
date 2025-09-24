import java.util.Scanner;


public class ATM {

    void login() {
       Scanner login = new Scanner(System.in);

       int balance = 10000;
       System.out.println("Select the option: ");
       while(true)
       {
           System.out.println("1. Deposit");
           System.out.println("2. Withdraw");
           System.out.println("3. Check Balance");
           System.out.println("4. Exit");
           int choice = login.nextInt();

           switch (choice)
           {
               case 1:
                   System.out.printf("Enter Deposit amount: ");
                   int deposit = login.nextInt();
                   System.out.print("Processing");
                   for (int i = 0; i < 3; i++) {
                       try {
                           Thread.sleep(500);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.print(".");
                   }
                   System.out.println();

                   if (deposit < 0)
                   {
                       System.out.println(RED +"Invalid deposit amount: "+RESET);
                   }
                   else {
                       System.out.println(GREEN +"Deposited Successfully"+RESET);
                   }
                   break;
               case 2:
                   System.out.printf("Enter Withdraw amount");
                   int withdraw = login.nextInt();
                   if (withdraw < 0)
                   {
                       System.out.println(RED +"Invalid withdraw amount: "+RESET);
                   }
                   else if (withdraw > balance)
                   {
                       System.out.println(RED+"Insufficient amount"+RESET);
                   }
                   else {
                       System.out.println(GREEN+"Withdraw Successfully"+RESET);
                   }
                   break;
               case 3:
                   System.out.println(YELLOW+"Your Balance is " + balance +RESET);
                   break;

               case 4:
                   System.out.println(BLUE+"Thank you for using our ATM ,Good Bye"+RESET);
                   return;
               default:
                   System.out.println(RED+"Invalid choice" +RESET);
           }
       }




    }
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";


        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            ATM atm = new ATM();

            System.out.println(BLUE + "=================================" + RESET);
            System.out.println("       💳 WELCOME TO ATM 💳       ");
            System.out.println(BLUE + "=================================" + RESET);

            int correctPin = 1234;

            for (int i = 1; i <= 3; i++) {
                System.out.printf("Enter the pin= ");
                int enteredPin = input.nextInt();
                if (correctPin == enteredPin) {
                    atm.login();
                    break;
                } else {
                      System.out.println("Wrong pin, Attempts left: " + (3-i));
                }


            }
        }

}