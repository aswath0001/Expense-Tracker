package EM.example.EM.Exception;


public class IncomeNotFoundException extends RuntimeException {
    public IncomeNotFoundException(Long id) {
        super("Income not found with id: " + id);
    }

    public IncomeNotFoundException(String message) {
        super(message);
    }
}