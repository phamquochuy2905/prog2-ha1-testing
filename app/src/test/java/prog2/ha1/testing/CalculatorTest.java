package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display correct number after pressing digit keys")
    void testDigitInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen
    @Test
    void calculatorCanDoTwoMinusTwo() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        assertEquals("0", calc.readScreen());
    }
    
    @Test
    // neuer roter Test
    void calculatorPercentage() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");
        assertEquals("0.5", calc.readScreen());
    }
    
     @Test
    // 2.roter Test
    void Fractional() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("1/x");
        calc.pressEqualsKey();
        assertEquals("0.1111111111111111", calc.readScreen());

    }
}

