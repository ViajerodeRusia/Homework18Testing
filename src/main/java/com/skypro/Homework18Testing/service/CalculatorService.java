package com.skypro.Homework18Testing.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(Integer num1, Integer num2, String operation) {
        switch (operation) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                if (num2 == 0) {
                    throw new IllegalArgumentException();
                }
                return (double) num1 / num2;
            default:
                return 0;
        }
    }
}