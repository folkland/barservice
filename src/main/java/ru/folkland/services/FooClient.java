package ru.folkland.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "localhost:9090", name = "foo-service")
public interface FooClient {

    @GetMapping("/hello")
    String sayHello();

    @GetMapping("/say/{some}")
    String saySome(@PathVariable("some") String some);

    @GetMapping("/param")
    String getParam(@RequestParam("params") int param);

    @GetMapping("/response")
    Response getResponse(@RequestParam("name") String name, @RequestParam("age") int age);

    @PostMapping("/request")
    Response getRequest(@RequestBody Request request);

    @GetMapping("/exception")
    int getException();

    @GetMapping("/model")
    FooPeopleRequest getModel(@RequestParam("name") String name);
}
