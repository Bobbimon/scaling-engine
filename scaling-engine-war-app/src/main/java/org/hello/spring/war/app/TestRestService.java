package org.hello.spring.war.app;

import org.scaling.engine.single.board.raspberry.pi.component.client.RaspberryPiClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController("testRestService")
public class TestRestService {

    private final RaspberryPiClient raspberryPiClient;

    private TestRestService(RaspberryPiClient raspberryPiClient) {
        this.raspberryPiClient = raspberryPiClient;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String getTest() {
        return "pong";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
//    public String createGPIOController(@RequestParam Long controllerId) {
    public String createGPIOController() {
        Long controllerId = 1L;
        long gpioController = raspberryPiClient.createGPIOController(controllerId);

        return "Instantiated a GPIO controller with id: " + gpioController;
    }

    @RequestMapping(value = "/high")
    public String setPinToHighOrLow(@RequestParam Boolean high) {
        Long pinId = 1L;
        raspberryPiClient.setPinToHighOrLow(pinId, high);

        String state = high ? "HIGH" : "LOW";
        return "Did set pin " + pinId + " to: " + state;
    }

    @RequestMapping(value = "/off")
    public String shutdownGPIOController() {
        Long controllerId = 1L;
        raspberryPiClient.shutdownGPIOController(controllerId);

        return "Did shutdown controller with id: " + controllerId;
    }
}
