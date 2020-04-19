package dev.jsondev;

public class NotExistingEmployeeException extends Exception{
    public NotExistingEmployeeException(String message) {
        super(message);
    }
}
