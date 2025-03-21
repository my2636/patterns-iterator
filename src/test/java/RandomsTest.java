import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomsTest {

    @ParameterizedTest
    @CsvSource({"10, 40", "-30, 20", "0, 10", "null, 5"})
    public void returningValuesTest(int min, int max) {
        //given

    }
}
