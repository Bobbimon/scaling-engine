import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

public class RaspberryPi3Impl implements SingleBoardComputer {

    public Boolean createGPIOController() {

        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        return gpio != null;
    }

    public LedColor getLedColor(int outputPin) {
        return null;
    }
}
