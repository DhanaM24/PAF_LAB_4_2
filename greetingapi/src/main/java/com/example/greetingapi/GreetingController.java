package com.example.greetingapi;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// controller for Greeting releated API endpoints
@RestController


public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong count = new AtomicLong();

    // endpoint for responding to calls for /greeting
    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(count.incrementAndGet(), String.format(template, "World"));
    }

    // endpoint for responding to calls for /greeting/name?name=<your_name>
    @GetMapping("/greeting/name")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "<Your name>") String name) {
        return new Greeting(count.incrementAndGet(), String.format(template, name));
    }
}
