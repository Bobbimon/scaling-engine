package org.scaling.engine.single.board.computer.component.test;

import org.junit.Test;
import org.scaling.engine.single.board.computer.client.SingleBoardComputer;

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
