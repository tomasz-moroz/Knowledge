package pl.knowledge.methods;

import org.junit.Assert;
import org.junit.jupiter.api.*;


class SimpleMethodsTest {

    private SimpleMethods simpleMethods;

    @BeforeEach
    void setUp() {
        simpleMethods = new SimpleMethods(2);
    }

    @Test
    void additionTest(){
        //given
        int number2 = 5;
        Integer expectedResult = 7;
        //when
        Integer result = simpleMethods.addition(number2);
        //then
        Assert.assertSame(result, expectedResult);
    }
}