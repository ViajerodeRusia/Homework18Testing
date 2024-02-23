package com.skypro.Homework18Testing.service;

import com.skypro.Homework18Testing.exception.DivisionByZeroException;
import com.skypro.Homework18Testing.exception.EmptyParametersException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(Integer num1, Integer num2, String operation) {
        if (num1 == null || num2 == null) {
            throw new EmptyParametersException("One or both parameters are null");
        }
        switch (operation) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                if (num2 == 0) {
                    throw new DivisionByZeroException("You are either trying to divide by zero or both parameters are zero or null");
                }
                return (double) num1 / num2;
            default:
                return 0;
        }
    }
}