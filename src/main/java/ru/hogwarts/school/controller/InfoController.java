package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.LongStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Value(value = "${server.port}")
    private int port;

    public InfoController() {
    }

    @GetMapping("/getPort")
    int getPort(){
        return port;
    }

    @GetMapping("/time-test-v1")
    public String getTimeTest1(){
        Long startTime = System.currentTimeMillis();

        Long sum = LongStream
                .iterate(1, a -> a + 1)
                .limit(1_000_000_0)
                .sum();

        Long finishTime = System.currentTimeMillis();

        return "Time " + (finishTime-startTime) + " mc";
    }
    @GetMapping("/time-test-v2")
    public String getTimeTest2(){
        Long startTime = System.currentTimeMillis();

        Long sum = LongStream
                .iterate(1, a -> a + 1)
                .limit(1_000_000_0)
                .parallel()
                .sum();

        Long finishTime = System.currentTimeMillis();

        return "Time " + (finishTime-startTime) + " mc";
    }

}
