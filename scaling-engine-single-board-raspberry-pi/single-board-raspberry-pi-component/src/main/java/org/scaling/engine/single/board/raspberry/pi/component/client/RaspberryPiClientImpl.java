package org.scaling.engine.single.board.raspberry.pi.component.client;


import org.scaling.engine.single.board.raspberry.pi.component.service.RaspberryPiService;

public class RaspberryPiClientImpl implements RaspberryPiClient {

    private final RaspberryPiService raspberryPiService;

    private RaspberryPiClientImpl(RaspberryPiService raspberryPiService) {
        this.raspberryPiService = raspberryPiService;
    }

    public long createGPIOController(long controllerId) {
        return raspberryPiService.createGPIOController(controllerId);
    }

    public long provisionOutputPin(long controllerId, Long pinId, String name, boolean high) {
        return raspberryPiService.provisionOutputPin(controllerId, pinId, name, high);
    }

    public void setPinToHighOrLow(Long pinId, boolean high) {
        raspberryPiService.setPinToHighOrLow(pinId, high);
    }

    public void shutdownGPIOController(long controllerId) {
        raspberryPiService.shutdownGPIOController(controllerId);
    }
}
