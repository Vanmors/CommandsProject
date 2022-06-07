package com.company.Commands;

import com.company.data.Flat;

import java.util.Stack;

public interface ICommand {

    public String execute(Stack<Flat> st);

}
