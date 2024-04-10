package org.calculator;

import org.calculator.components.CalculatorApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        CalculatorApp calculator = context.getBean(CalculatorApp.class);

        calculator.run();

    }
}