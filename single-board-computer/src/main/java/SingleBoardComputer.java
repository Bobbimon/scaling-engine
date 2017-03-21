public interface SingleBoardComputer {

    Boolean createGPIOController();

    LedColor getLedColor(int outputPin);
}
