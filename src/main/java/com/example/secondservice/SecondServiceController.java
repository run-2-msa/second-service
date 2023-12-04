package com.example.secondservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/second-service")
public class SecondServiceController {

    @GetMapping("/welcome") // develop
    public String welcome(){
        return "Welcome to the Second service.";
    }

    @GetMapping("/message") // filter-java, filter-yaml
    public String message(@RequestHeader(name = "second-request", required = false) String header){
        log.info("header: {}", header);
        return "Welcome to the First service.";
    }

    @GetMapping("/check") // Custom Filter, Global Filter, lb
    public String check(){
        return "Hi, there, This is a message from Second Service";
    }
}
