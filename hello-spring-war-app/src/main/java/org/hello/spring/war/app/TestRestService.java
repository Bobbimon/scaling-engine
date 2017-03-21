package org.hello.spring.war.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController("testRestService")
public class TestRestService {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String getTest() {
        return "pong";
    }

}
