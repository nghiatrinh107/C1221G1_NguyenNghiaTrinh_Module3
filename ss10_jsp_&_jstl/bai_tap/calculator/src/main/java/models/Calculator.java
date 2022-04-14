package models;

public class Calculator {
    public static float calculate(float firstOperand, float secondOperand, char operator ) throws ArithmeticException {
        float result = 0;
        switch (operator) {
            case '+':
                return result=firstOperand + secondOperand;
            case '-':
                return result=firstOperand - secondOperand;
            case '*':
                return result=firstOperand * secondOperand;
            case '/':
                if (secondOperand == 0)
                    throw new ArithmeticException("Can't divide by zero");
                else
                    return result=firstOperand / secondOperand;

        }
        return result;
    }
}
