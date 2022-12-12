import java.util.HashMap;
import java.util.Map;

public class Expense {

    private static Integer IdCounter;
    private static Map<Integer, Expense> Expenses;
    private Double Amount;
    private Integer Id;
    
    public Expense(Double Amount){
        this.Amount = Amount;
        this.Id = Expense.IdCounter;
        Expense.IdCounter += 1;
        Expense.Expenses.put(this.Id, this);
    }
    
    public Double GetAmount(){
        return this.Amount;
    }
    
    public void SetAmount(Double Amount){
        this.Amount = Amount;
    }
    
    public Integer GetExpenseId(){
        return this.Id;
    }
    
    public static Expense GetExpenseById(Integer ExpenseId){
        return Expense.Expenses.get(ExpenseId);
    }
    
    public static void Setup(){
        Expense.IdCounter = 0;
        Expense.Expenses = new HashMap<Integer, Expense>();
    }
    
}
