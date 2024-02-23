package com.skypro.Homework18Testing.service;

import com.skypro.Homework18Testing.exception.DivisionByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @Test
    void calculateThrowsExceptionForDivisionByZero() {
        Assertions.assertThrows(DivisionByZeroException.class, () ->
                calculatorService.calculate(num1, 0, "divide"));
    }

    @ParameterizedTest
    @CsvSource({"10, 2, add, 12.0",
            "10, 2, subtract, 8.0",
            "10, 2, multiply, 20.0",
            "10, 2, divide, 5.0"})
    void calculateParameterizedTest(int num1, int num2, String operation, double expectedResult) {
        double actualResult = calculatorService.calculate(num1, num2, operation);
        assertEquals(expectedResult, actualResult);
    }
}