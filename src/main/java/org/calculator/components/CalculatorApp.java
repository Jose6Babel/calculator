package org.calculator.components;

import lombok.SneakyThrows;
import org.calculator.ConfigCalculator;
import org.calculator.services.IOperationsService;
import org.calculator.services.IPrintMessagesService;
import org.springframework.stereotype.Component;

@Component
public class CalculatorApp {
    IPrintMessagesService printMessages;
    IOperationsService operationsService;

    public CalculatorApp (IOperationsService operationsService, IPrintMessagesService printMessages) {
        this.operationsService = operationsService;
        this.printMessages = printMessages;
    }

    @SneakyThrows
    public void run() {
        ConfigCalculator configCalculator = new ConfigCalculator();
        printMessages.printMenu();
        configCalculator.setNumOperator(operationsService.writeNumOperator());

        while (configCalculator.numOperator!=5) {
            configCalculator.setNumOne(operationsService.writeNum1());
            configCalculator.setNumTwo(operationsService.writeNum2());

            try {
                String operatorOrError = operationsService.calculateResultAndReturnOperator(configCalculator);
                printMessages.printResult(configCalculator, operatorOrError);
            } catch (ArithmeticException error) {
                System.err.println("No se puede dividir un número entre 0");
            }

            printMessages.printMenu();
            configCalculator.setNumOperator(operationsService.writeNumOperator());
        }
    }

}
