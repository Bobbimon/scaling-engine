package org.scaling.engine.single.board.raspberry.pi.component.service;

public interface RaspberryPiService {

    long createGPIOController(long controllerId);

    long provisionOutputPin(long controllerId, Long pinId, String name, boolean high);

    void setPinToHighOrLow(Long pinId, boolean high);

    void shutdownGPIOController(long controllerId);

}
