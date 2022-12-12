public class Category extends ExpenseContainer {
    
    private Double WarningLimit;
    private boolean LimitSet;
    
    public Category(){}
    
    public boolean DoesExceedLimit(){
        if(!this.LimitSet){return false;}
        return this.GetTotalExpenses() > this.WarningLimit;
    }
    
    public void UpdateLimit(Double WarningLimit){
        this.WarningLimit = WarningLimit;
        this.LimitSet = true;
        if(this.DoesExceedLimit()){
            System.out.println("[Warning] This category exceeds your warning limit!");
        }
    }
    
    @Override
    public void AddExpense(Integer ExpenseId){
        super.AddExpense(ExpenseId);
        if(this.DoesExceedLimit()){
            System.out.println("[Warning] This category exceeds your warning limit!");
        }
    }
    
}
