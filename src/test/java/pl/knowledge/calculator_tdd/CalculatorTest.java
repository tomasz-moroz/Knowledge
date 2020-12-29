package pl.knowledge.calculator_tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    int number1 = 3;
    int number2 = 3;
    int number3 = 0;
    double number4 = 64;
    int number5 = 7;
    double number6 = 3;

    @Test
    void addition_checkWithNumbers_resultNumber() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.addition(number1, number2);
        //then
        Assertions.assertSame(result, 6);
    }

    @Test
    void subtraction_checkWithNumbers_resultNumber() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.subtraction(number1, number2);
        //then
        Assertions.assertSame(result, 0);
    }

    @Test
    void multiplication_checkWithNumbers_resultNumber() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.multiplication(number1, number2);
        //then
        Assertions.assertSame(result, 9);
    }

    @Test
    void division_checkWithNumbers_resultNumber() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result =calculator.division(number1, number2);
        //then
        Assertions.assertSame(result, 1);
    }

    @Test
    void division_checkWithZero_throwsArithmeticException() {
        //given
        Calculator calculator = new Calculator();
        //when
        //then
        Assertions.assertThrows(ArithmeticException.class, ()->calculator.division(number1, number3));
    }

    @Test
    void exponentiation_checkWithNumbers3and3_resultNumber27() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result =calculator.exponentiation(number1, number2);
        //then
        Assertions.assertSame(result, 27);
    }

    @Test
    void exponentiation_checkWithNumbers3and7_resultNumber() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.exponentiation(number1, number5);
        //then
        Assertions.assertEquals(result, 2187);
    }

    @Test
    void square_checkWithNumber64_resultNumber8() {
        //given
        Calculator calculator = new Calculator();
        //when
        double result =calculator.square(number4);
        //then
        Assertions.assertEquals(result, 8);
    }
}