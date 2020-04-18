package dev.jsondev;

public class NotExistingEmployee extends Exception{
    public NotExistingEmployee(String message) {
        super(message);
    }
}
