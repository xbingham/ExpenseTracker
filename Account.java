import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Account extends ExpenseContainer {

    private String AccountName;
    private Map<String, Category> Categories;
    
    public Account(String AccountName){
        super();
        this.AccountName = AccountName;
        this.Categories = new HashMap<>();
    }
    
    /**
     * Registers a new category into this account
     * @param CategoryName Name of the category
     */
    public void RegisterCategory(String CategoryName){
        if(this.Categories.get(CategoryName) != null){return;}
        this.Categories.put(CategoryName, new Category());
    }
    
    /**
     * Registers a new expense into this account
     * @param ExpenseAmount The expense amount
     * @param CategoryName The name of the category
     */
    public void RegisterExpense(Double ExpenseAmount, String CategoryName){
        
        //Register new expense
        final Expense NewExpense = new Expense(ExpenseAmount);
        final Integer ExpenseId = NewExpense.GetExpenseId();
        this.AddExpense(ExpenseId);
        
        //Register expense to category if it exists
        if(this.Categories.get(CategoryName) != null){
            this.Categories.get(CategoryName).AddExpense(ExpenseId);
        }
        
    }
    
    /**
     * Sets a limit on any given category
     * @param Limit The expense limit
     * @param CategoryName The name of the category
     */
    public void SetCategoryWarningLimit(Double Limit, String CategoryName){
        if(this.Categories.get(CategoryName) == null){return;}
        this.Categories.get(CategoryName).UpdateLimit(Limit);
    }
    
    /**
     * Displays account information
     */
    public void DisplayExpenseInfo(){
        
        //Displays overview account info
        System.out.println("Account Information For: " + this.AccountName + "\n" +
            "---------------------------------------"
        );
        
        System.out.println(String.format("Total Account Expenses: %,.2f\n", this.GetTotalExpenses()));
        
        //Iterates through all categories and displays their info
        final Iterator<Map.Entry<String, Category>> Iterator = this.Categories.entrySet().iterator();
        while(Iterator.hasNext()){
            final Map.Entry<String, Category> Entry = Iterator.next();
            System.out.println(String.format("[Category] %s\n<-------------->" , Entry.getKey())
            );
            System.out.println(String.format("Total Category Expenses: %,.2f", Entry.getValue().GetTotalExpenses()));
            System.out.println("Exceeds Warning Limit: " + Entry.getValue().DoesExceedLimit() + "\n");
        }
        
    }
    
}
