package org.scaling.engine.single.board.raspberry.pi.component.client;


public class FakeRaspberryPiClientImpl implements RaspberryPiClient {

    public long createGPIOController(long controllerId) {
        return controllerId;
    }

    public long provisionOutputPin(long controllerId, Long pinId, String name, boolean high) {
        return pinId;
    }

    public void setPinToHighOrLow(Long pinId, boolean high) {

    }

    public void shutdownGPIOController(long controllerId) {

    }
}
