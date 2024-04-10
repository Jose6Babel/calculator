package org.calculator.services;


import org.calculator.ConfigCalculator;
import org.springframework.stereotype.Service;

@Service
public class PrintMessagesService implements IPrintMessagesService {

    public void printMenu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Bienvenido a la calculadora, selecciona una operación:");
        System.out.println("1.- Sumar");
        System.out.println("2.- Restar");
        System.out.println("3.- Multiplicar");
        System.out.println("4.- Dividir");
        System.out.println("5.- Salir");
    }

    public void printResult(ConfigCalculator configCalculator, String operator) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Resultado:");
        System.out.println(configCalculator.numOne + " " +
                           operator + " " +
                           configCalculator.numTwo + " = " +
                           configCalculator.getResult()
        );
    }
}
