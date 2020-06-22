package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredictTheWinnerTest {

    @Test
    public void testPredictTheWinner() {
        System.out.println("testPredictTheWinner");
        PredictTheWinner instance = new PredictTheWinner();

        assertEquals(false, instance.PredictTheWinner(new int[] {1, 5, 2}));
        assertEquals(true, instance.PredictTheWinner(new int[] {1, 5, 233, 7}));
    }

}
