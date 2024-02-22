package com.skypro.Homework18Testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private Integer num1 = 10;
    private Integer num2 = 2;

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void calculate() {
        Double addResult = calculatorService.calculate(num1, num2, "add");
        Double subtractResult = calculatorService.calculate(num1, num2, "subtract");
        Double multiplyResult = calculatorService.calculate(num1, num2, "multiply");
        Double divideResult = calculatorService.calculate(num1, num2, "divide");

        Assertions.assertEquals(12.0, addResult);
        Assertions.assertEquals(8.0, subtractResult);
        Assertions.assertEquals(20.0, multiplyResult);
        Assertions.assertEquals(5.0, divideResult);
    }
}