import java.util.HashMap;
import java.util.Map;

public class ExpenseTracker {

    private static Account CurrAccount;
    private static Map<String, Account> Accounts;

    /**
     * Exits the application.
     * @param args
     */
    public static void ExitApp(){
        System.out.println("Goodbye!");
        System.exit(0);
    };

    /**
     * Enters the account login screen, allows the user to login to an existing account.
     * @param args
     */
    public static void EnterAccountLogin(){
        
        final String Account = InputWrapper.GetStringInput(
            "Enter Account Name:"
        );
        
        if(ExpenseTracker.Accounts.get(Account) == null){
            System.out.println("Error: No Account Found By That Name.\n");
            ExpenseTracker.EnterAccountSetup();
        }else{
            ExpenseTracker.CurrAccount = ExpenseTracker.Accounts.get(Account);
            ExpenseTracker.EnterMenu();
        }
        
    }

    /**
     * Enters the account creation screen, allows the user to create a new account.
     * @param args
     */
    public static void EnterAccountCreation(){

        final String AccountName = InputWrapper.GetStringInput(
            "Enter Account Name:"
        );
        
        if(ExpenseTracker.Accounts.get(AccountName) != null){
            System.out.println("Error: Account Already Exists.\n");
        }else{
            System.out.println("Success! Account Created.\n");
            ExpenseTracker.Accounts.put(AccountName, new Account(AccountName));
        }
        
        ExpenseTracker.EnterAccountSetup();

    }


    /**
     * Enters the account setup screen, offers the user to be able to create or login to an account.
     * @param args
     */
    public static void EnterAccountSetup(){

        final Integer Action = InputWrapper.GetIntInput(
            "Welcome to the Expense Tracker App:\n" +
            "1. Login to an Existing Account\n" +
            "2. Create a new Account\n" +
            "3. Exit App"
        );

        switch(Action){
            case(1):{
                ExpenseTracker.EnterAccountLogin();
                break;
            }
            case(2):{
                ExpenseTracker.EnterAccountCreation();
                break;
            }
            case(3):{
                ExpenseTracker.ExitApp();
                break;
            }
            default:{
                ExpenseTracker.EnterAccountSetup();
            }
        }

    }

    /**
     * Logs the user out of the current account.
     * @param args
     */
    public static void Logout(){
        ExpenseTracker.CurrAccount = null;
        ExpenseTracker.EnterAccountSetup();
    }

    /**
     * Returns the user back to the start page; if logged in they will be presented with an account setup screen.
     * @param args
     */
    public static void EnterMenu(){

        if(ExpenseTracker.CurrAccount == null){
            ExpenseTracker.EnterAccountSetup();
        }

        final Integer Action = InputWrapper.GetIntInput(
            "Welcome to the Expense Tracker App:\n" +
            "1. Register an Expense Category\n" +
            "2. Register a new Expense\n" +
            "3. Display Expense Information\n" +
            "4. Set Category Expense Limit\n" +
            "5. Logout of Account\n" +
            "6. Exit App"
        );

        switch(Action){
            case(1):{
                final String CategoryName = InputWrapper.GetStringInput(
                    "Enter Category Name:"
                );
                ExpenseTracker.CurrAccount.RegisterCategory(CategoryName);
                System.out.println("Category Successfully Registered!\n");
                break;
            }
            case(2):{
                final Double ExpenseAmount = InputWrapper.GetDoubleInput(
                    "Enter Expense Amount:"
                );
                final String CategoryName = InputWrapper.GetStringInput(
                    "Enter Category Name:"
                );
                ExpenseTracker.CurrAccount.RegisterExpense(ExpenseAmount, CategoryName);
                System.out.println("Expense Successfully Registered!\n");
                break;
            }
            case(3):{
                ExpenseTracker.CurrAccount.DisplayExpenseInfo();
                break;
            }
            case(4):{
                final Double LimitAmount = InputWrapper.GetDoubleInput(
                    "Enter The Limit You Want To Be Warned At:"
                );
                final String CategoryName = InputWrapper.GetStringInput(
                    "Enter Category Name:"
                );
                ExpenseTracker.CurrAccount.SetCategoryWarningLimit(LimitAmount, CategoryName);
                break;
            }
            case(5):{
                ExpenseTracker.Logout();
                return;
            }
            case(6):{
                ExpenseTracker.ExitApp();
                return;
            }
        }
        
        ExpenseTracker.EnterMenu();
        
    }

    /**
     * The start of the program. Initializes all systems and enters the user into the software-loop.
     * @param args
     */
    public static void main(String[] args){

        //Var setup
        ExpenseTracker.CurrAccount = null;
        ExpenseTracker.Accounts = new HashMap<>();

        //Program setup
        InputWrapper.Setup();
        Expense.Setup();

        //Program init
        ExpenseTracker.EnterMenu();

    }

}