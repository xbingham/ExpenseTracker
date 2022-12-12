import java.util.ArrayList;
import java.util.List;

public class ExpenseContainer {
    
    private ArrayList<Integer> Expenses;
    private Double TotalExpenses;
    
    public ExpenseContainer(){
        this.Expenses = new ArrayList<Integer>();
        this.TotalExpenses = 0.0;
    }
    
    public void AddExpense(Integer ExpenseId){
        this.Expenses.add(ExpenseId);
        this.TotalExpenses += Expense.GetExpenseById(ExpenseId).GetAmount();
    }
    
    public Double GetTotalExpenses(){
        return this.TotalExpenses;
    }
    
}
