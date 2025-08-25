package EM.example.EM.Exception;



public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(Long id) {
        super("Expense not found with id: " + id);
    }

    public ExpenseNotFoundException(String message) {
        super(message);
    }
}