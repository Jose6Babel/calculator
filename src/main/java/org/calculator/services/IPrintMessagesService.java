package org.calculator.services;

import org.calculator.ConfigCalculator;

public interface IPrintMessagesService {

    public void printMenu();
    public void printResult(ConfigCalculator configCalculator, String operator);

}
