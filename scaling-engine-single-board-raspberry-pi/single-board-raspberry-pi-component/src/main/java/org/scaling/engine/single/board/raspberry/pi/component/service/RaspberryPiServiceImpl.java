package org.scaling.engine.single.board.raspberry.pi.component.service;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.GpioUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class RaspberryPiServiceImpl implements RaspberryPiService {

    private Map<Long, GpioController> gpioControllerMap;
    private Map<Long, GpioPinDigitalOutput> gpioPinDigitalOutputMap;

    private RaspberryPiServiceImpl() {
        this.gpioControllerMap = new HashMap<Long, GpioController>();
        this.gpioPinDigitalOutputMap = new HashMap<Long, GpioPinDigitalOutput>();
    }

    public long createGPIOController(long id) {

        GpioUtil.enableNonPrivilegedAccess();
        if(GpioUtil.isPrivilegedAccessRequired()){
            System.err.println("*****************************************************************");
            System.err.println("Privileged access is required on this system to access GPIO pins!");
            System.err.println("*****************************************************************");
            return 1;
        }

        GpioController gpioController = GpioFactory.getInstance();

        if (gpioController == null) {
            throw new RuntimeException("Failed to instantiate a Raspberry pi GPIO controller");
        }

        gpioControllerMap.put(id, gpioController);
        return id;
    }

    public long provisionOutputPin(long controllerId, Long pinId, String name, boolean high) {

        if (!gpioControllerMap.containsKey(controllerId)) {
            throw new NoSuchElementException("There's no GPIO controller with id: " + controllerId);
        }
        PinState pinState = high ? PinState.HIGH : PinState.LOW;

        GpioController gpioController = gpioControllerMap.get(controllerId);
        GpioPinDigitalOutput outputPin = gpioController.provisionDigitalOutputPin(RaspiPin
                .getPinByAddress(pinId.intValue()), name, pinState);
        outputPin.setShutdownOptions(true, PinState.LOW);

        gpioPinDigitalOutputMap.put(pinId, outputPin);

        return pinId;
    }

    public void setPinToHighOrLow(Long pinId, boolean high) {

        if (!gpioPinDigitalOutputMap.containsKey(pinId)) {
            throw new NoSuchElementException("There's no output pin with id: " + pinId);
        }

        if (high) {
            gpioPinDigitalOutputMap.get(pinId).high();
        } else {
            gpioPinDigitalOutputMap.get(pinId).low();
        }
    }

    public void shutdownGPIOController(long controllerId) {
        if (!gpioControllerMap.containsKey(controllerId)) {
            throw new NoSuchElementException("There's no GPIO controller with id: " + controllerId);
        }

        gpioControllerMap.get(controllerId).shutdown();
    }
}
