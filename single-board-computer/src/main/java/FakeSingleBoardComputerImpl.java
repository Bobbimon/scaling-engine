public class FakeSingleBoardComputerImpl implements SingleBoardComputer {

    public Boolean createGPIOController() {
        return true;
    }

    public LedColor getLedColor(int outputPin) {
        return LedColor.RED;
    }
}
