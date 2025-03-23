import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class InputValuesTest {

    @ParameterizedTest
    @CsvSource({"6, 1"})
    public void incorrectValuesTest(int min, int max) {

        //then
        assertThrows(Exception.class, () -> throwAnyException(min, max));
    }

    @ParameterizedTest
    @CsvSource({"-3, -1", "1, 1", "4, 8"})
    public void correctValuesTest(int min, int max) {

        //then
        assertDoesNotThrow(() -> doesNotThrowAnyException(min, max));
    }

    void throwAnyException(int min, int max) {

        //when
        try {
            for (int r : new Randoms(min, max)) {
                System.out.println("Выпало число: " + r);
                if (r == max) {
                    System.out.println("Выпало число " + max + ", давайте на этом закончим");
                    break;
                }
            }
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
    }

    public void doesNotThrowAnyException(int min, int max) {

        //given
        int rr = 0;

        //when
        for (int r : new Randoms(min, max)) {
            rr = r;
            System.out.println("Выпало число: " + r);
            if (r == max) {
                System.out.println("Выпало число " + max + ", давайте на этом закончим");
                break;
            }
        }


        //then
        assertTrue(rr >= min || rr <= max);
    }

}
