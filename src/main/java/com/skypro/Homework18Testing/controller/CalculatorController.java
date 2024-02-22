package com.skypro.Homework18Testing.controller;

import com.skypro.Homework18Testing.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(@Autowired CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String calculatorForm(Model model) {
        model.addAttribute("result", "");
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2,
                            @RequestParam("operation") String operation, Model model) {
        try {
            double result = calculatorService.calculate(num1, num2, operation);
            model.addAttribute("result", "Result: " + result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("result", "You are trying to divide by zero. It's not allowed.");
            return "calculator"; // возвращаем страницу с сообщением об ошибке
        }
        return "calculator";
    }
}