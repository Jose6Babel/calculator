package org.calculator.services;


import org.calculator.ConfigCalculator;

import java.io.IOException;

public interface IOperationsService {

    public int writeNumOperator() throws IOException;
    public int writeNum1() throws IOException;
    public int writeNum2() throws IOException;
    public String calculateResultAndReturnOperator(ConfigCalculator configCalculator);

}
