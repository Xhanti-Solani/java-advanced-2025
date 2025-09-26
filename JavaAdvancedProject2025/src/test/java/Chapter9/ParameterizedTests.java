package Chapter9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Xhanti Solani
 */

public class ParameterizedTests {
    @ParameterizedTest(name = "Test Pass Mark - [{index}]: {arguments}")
    @ValueSource(doubles = {55.5, 69.8, 26.9, 87.66, 64})
    void testPassMark(double testmark){
        boolean expected = true;
        boolean actual = testmark >= 65;

        assertEquals(expected, actual, "Pass Mark should be >= 65 [" + testmark + "]");
        System.out.println("testMark: " + testmark);
    }

    @ParameterizedTest(name = "Test names  - [{index}]: {arguments}")
    @ValueSource(strings = {"Kate", "Jake", "Jessica", "Carol", "Tom", "John", "Jeckson", "Mike"})
    void testNameStartWithJ(String name){
        assertTrue(name.startsWith("J"), name + " doesn't start with J");
    }

    @ParameterizedTest
    @CsvSource(value = {"Milk,20.99,50", "Cheese,55.59,25", "Eggs,78.99,60", "Bread,18.99,24"})
    void testLowStockProducts(String name, double price, int quantity){

        assertTrue(quantity < 50, "There is enough stock [" + quantity + "] for [" + name + "]");
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Student Test Marks.csv", numLinesToSkip = 1)
    void testFailedStudents(String firstname, String lastname, double testmark){

        assertTrue(testmark < 65, "Student [" + testmark + "] should be >= 65 [" + firstname + "] managed to pass the test [" + testmark + "]");

        System.out.println("firstname = " + firstname + ", lastname = " + lastname + ", testmark = " + testmark);

    }

    @ParameterizedTest
    @MethodSource("hobbies")
    void testHobbies(List<String> hobbies){
        System.out.println("hobbies = " + hobbies);
    }


    @ParameterizedTest
    @MethodSource("randomNumbers")
    void testRandomNumbers(int number){

        assertTrue(number %2 == 0, "Random number should be greater than 0");

        System.out.println("randomNumbers = " + number);
    }

    @ParameterizedTest
    @MethodSource("randomNumbers")
    void testEvenNumbers(int number){

        assertTrue(number %2 == 0, number + " is not an even number");
        System.out.println("Numbers = " + number);
    }

    @ParameterizedTest
    @MethodSource
    void randomNumbers(int number){

        System.out.println("number = " + number);
    }

    @ParameterizedTest
    @MethodSource("Chapter9.DataStore#randomNumbers")
    void testOddNumbers(int number){
        assertEquals(0, number % 2, number + " is not an odd number");
    }

    static List<Integer> randomNumbers(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int count = random.nextInt(5, 15);
        for(int i = 0; i < count; i++){
            list.add(random.nextInt(10, 70));
        }
        return list;
    }

    static Stream<String> hobbies(){
        return Stream.of("Tennis", "Hockey", "Chess", "Hiking", "Soccer");
    }
}
