package org.scaling.engine.single.board.computer.client;

public class FakeSingleBoardComputerImpl implements SingleBoardComputer {

    public Boolean createGPIOController() {
        return true;
    }

    public LedColor getLedColor(int outputPin) {
        return LedColor.RED;
    }

}
