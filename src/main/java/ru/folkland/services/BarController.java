package ru.folkland.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class BarController {

    @Value("${bar}")
    private String bar;

    @Autowired
    private FooClient fooClient;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() throws UnknownHostException {
        return ResponseEntity.ok(bar + " call foo and:" + fooClient.sayHello()+ "  server host " + InetAddress.getLocalHost().getHostAddress());
    }

    @GetMapping("/say/{some}")
    public ResponseEntity<String> saySome(@PathVariable("some") String some) {
        return ResponseEntity.ok(bar + " call: " + fooClient.saySome(some));
    }

    @GetMapping("/param")
    public ResponseEntity<String> getParam(@RequestParam("params") int param) {
        return ResponseEntity.ok(bar + " call: " + fooClient.getParam(param));
    }

    @GetMapping("/response")
    public ResponseEntity<Response> getResponse(@RequestParam("name") String name, @RequestParam("age") int age) {
        Response response = fooClient.getResponse(name, age);
        response.setName(bar + " call: " + response.getName());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/request")
    public ResponseEntity<Response> getRequest(@RequestBody Request request) {
        return ResponseEntity.ok(fooClient.getRequest(request));
    }

    @GetMapping("/exception")
    public ResponseEntity<Integer> getException() {
        return ResponseEntity.ok(fooClient.getException());
    }

    @GetMapping("/model")
    public ResponseEntity<FooPeopleRequest> getModel(@ModelAttribute FooPeopleRequest fooPeopleRequest) {
        return ResponseEntity.ok(fooClient.getModel(fooPeopleRequest.getName()));
    }
}
