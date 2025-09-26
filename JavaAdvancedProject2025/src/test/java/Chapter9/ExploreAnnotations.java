package Chapter9;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExploreAnnotations {

    @BeforeAll
    static void setUpBeforeClass(){
        System.out.println("@Getting things started...\n");
    }
    @AfterAll
    static void tearDownAfterClass(){
        System.out.println("\n@AfterAll finished...");
    }
    @BeforeEach
    public void beforeEachTest() {
        System.out.println("@BeforeEachTest...");
    }

    @Test
    @DisplayName("TC1 - First Test")
    @Order(1)
    @Tag("Sanity")
    public void firstTest() {
        System.out.println("First Test Method");
    }
    @Test
    @DisplayName("TC2 - Second Test")
    @Order(3)
    @Tag("Regression")
    public void secondTest() {
        System.out.println("Second Test Method");
    }
    @Test
    @DisplayName("TC3 - Third Test")
    @Order(2)
    @Tag("Integration")
    public void thirdTest() {
        System.out.println("Third Test Method");
    }
    @Test
    @DisplayName("TC4 - Fourth Test")
    @Order(4)
    @Tag("Confirmation")
    public void fourthTest() {
        System.out.println("Fourth Test Method");
    }
}
