import org.junit.Test;

import javax.inject.Inject;

public class RaspberryPiGPIOTest {

    @Inject
    private static SingleBoardComputer singleBoardComputer;

    @Test
    public void testClass() {

        singleBoardComputer.getLedColor(1);

        System.out.println("hello");
    }
}
