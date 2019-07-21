package pl.conectis;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CalcTest {


    //System Under Test  ->SUT
    Calc calc = new Calc();

    @BeforeEach
    void preapareData() {
        System.out.println("Wykonuje inicjalizacje");
        List<Double> list = Arrays.asList(2d, 3d, 4d, 5d, 6d);
        calc.setValues(list);


    }

    @AfterEach
    void cleanUp() {
        System.out.println("Czyszczenie po kazdym tescie ");
        calc.clear();
    }

    @Test
    @DisplayName("Very special adding test")
    @Tag("important")
    void checkAdding() {
        assertEquals(5, calc.sum(2, 3));

    }

    @Test
    @Tag("important")
    void checkStd() {
        assertEquals(1.5811388300841898, calc.std());
    }


    @Test
    void checkMean() {

        assertEquals(4.0, calc.mean(), () -> "Bład w obliczeniu");
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 22, 98, 124, 512})
    void checkIsEven(int l) {
        assertTrue(calc.isEven(l));
    }

    @ParameterizedTest
    @CsvSource({"2,3,5", "1,0,1", "4,8,12", "-5,5,0", "8,-10,-2"})
    void checkAdding(int l1, int l2, int result) {
        assertEquals(result, calc.sum(l1, l2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "numbers.csv")
    void checkAddingFromFile(int l1, int l2, int result){
        assertEquals(result, calc.sum(l1, l2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "even_odd_numbers.csv")
    void checkAddingFromFile(int l1, boolean result){
        assertEquals(result, calc.isEven(l1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "numberTomultiply.csv")
    void checkMultiplyTest(long a,long b,long result){
        assertEquals(result,calc.multiply(a,b));
    }

    @ParameterizedTest
    @CsvSource({"4,2,2","10,5,2"})
    void checkDevide(double x,double y,double results){
        assertEquals(results,calc.divide(x,y));
    }


}
