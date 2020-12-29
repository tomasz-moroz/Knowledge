package pl.knowledge.calculator_tdd;

public class Calculator implements CalculatorTDD {
    @Override
    public int addition(int a, int b) {
        int c = a + b;
        return c;
    }

    @Override
    public int subtraction(int a, int b) {
        int c = a - b;
        return c;
    }

    @Override
    public int multiplication(int a, int b) {
        int c = a * b;
        return c;
    }

    @Override
    public int division(int a, int b) {
        if (a != 0 || b != 0) {
            int c = a / b;
            return c;
        }
        throw new ArithmeticException("You cant divide by 0!!!");
    }

    @Override
    public int exponentiation(int a, int b) {
        int c = a;
        for (int i = 1; i < b; i++) {
            c = c*a;
        }
        return c;
    }

    @Override
    public double square(double a) {
        return Math.sqrt(a);
    }
}
