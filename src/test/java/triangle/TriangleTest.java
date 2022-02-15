package triangle;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.logging.Logger;

public class TriangleTest {

    String error = "Это не стороны треугольника";

    @Test
    @DisplayName("Проверка что стороны не являются треугольником")
    public void isNotTriangle() {
        Assertions.assertThrows(MyException.class,()-> Triangle.areaOfTriangle(1,1,3),"exception не работает");
        Assertions.assertThrows(MyException.class,()-> Triangle.areaOfTriangle(-3,-4,-5),"exception не работает");;
    }

    @Test
    @DisplayName("Проверка площади прямоугольника")
    public void Triangle() throws MyException {
        double s = Triangle.areaOfTriangle(3,4,5);
       assertEquals(6,s);
    }

    @Test
    @DisplayName("Проверка площади равностороннего треугольника")
    public void Triangle2() throws MyException {
        double s = Triangle.areaOfTriangle(6,6,6);
        assertEquals(15.589,s);
    }

    @Test
    @DisplayName("Проверка площади равнобедренного треугольника")
    public void Triangle3() throws MyException {
        double s = Triangle.areaOfTriangle(6,6,4);
        assertEquals(11.314,s);
    }
}
