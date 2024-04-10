package org.calculator.services;

import org.calculator.ConfigCalculator;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class OperationsService implements IOperationsService {

    public int writeNumOperator() throws IOException {
        int numOperator = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (numOperator < 1 || numOperator > 5) {
            String printOperator = br.readLine();
            try {
                numOperator = Integer.parseInt(printOperator);
                if (numOperator < 1 || numOperator > 5) {
                    System.err.println("Error, introduzca un numero valido");
                }
            } catch (NumberFormatException error) {
                System.err.println("Error, introduzca un numero valido");
            }
        }
        return numOperator;
    }
    public int writeNum1() throws IOException {
        System.out.println("Ahora introduzca el primer número");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOne = 0;

        String printOperator = br.readLine();
        try {
            numOne = Integer.parseInt(printOperator);

        } catch (NumberFormatException error) {
            System.err.println("Número introducido no válido");
        }
        return numOne;
    }
    public int writeNum2() throws IOException {
        System.out.println("Ahora introduzca el segundo número");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTwo = 0;
        String printOperator = br.readLine();
        try {
            numTwo = Integer.parseInt(printOperator);
        } catch (NumberFormatException error) {
            System.err.println("Número introducido no válido");
        }

        return numTwo;
    }
    public String calculateResultAndReturnOperator(ConfigCalculator configCalculator) {
        int result = 0;
        String operator = "";
        switch (configCalculator.numOperator) {
            case 1:
                result = configCalculator.getNumOne() + configCalculator.getNumTwo();
                operator = "+";
                break;
            case 2:
                result = configCalculator.getNumOne() - configCalculator.getNumTwo();
                operator = "-";
                break;
            case 3:
                result = configCalculator.getNumOne() * configCalculator.getNumTwo();
                operator = "x";
                break;
            case 4:
                if (configCalculator.getNumTwo() == 0) {
                    throw new ArithmeticException();
                } else {
                    result = configCalculator.getNumOne() / configCalculator.getNumTwo();
                }
                operator = ":";
                break;
        }
        configCalculator.setResult(result);
        return operator;
    }
}
