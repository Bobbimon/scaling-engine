package org.scaling.engine.single.board.computer.client;

import org.scaling.engine.single.board.computer.domain.LedColor;

public interface SingleBoardComputer {

    Boolean createGPIOController();

    LedColor getLedColor(int outputPin);
}
