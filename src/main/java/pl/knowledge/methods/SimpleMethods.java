package pl.knowledge.methods;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleMethods {

    private int number1 = 5;

    public int addition(int number2) {
        int result = number1 + number2;
        return result;
    }
}
