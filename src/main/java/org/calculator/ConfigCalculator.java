package org.calculator;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class ConfigCalculator {
    public int numOne;
    public int numTwo;
    public int numOperator;
    public int result;

}
