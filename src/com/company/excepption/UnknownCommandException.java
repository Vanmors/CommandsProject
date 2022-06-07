package com.company.excepption;

/**
 * проверяет корректность введённых команд
 */
public class UnknownCommandException extends Exception{
    private String command;
    public UnknownCommandException(String command) {
        this.command = command;
        System.out.println("Unknown command " + command);
    }
}