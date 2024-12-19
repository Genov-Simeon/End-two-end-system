package servicelog.controller;

import servicelog.model.LogRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class LogController {

    @PostMapping("/log")
    public ResponseEntity<Void> logRequest(@RequestBody LogRequest logRequest) {
        System.out.println("A request with the following input was received: " + logRequest.getInput());
        System.out.println("Result after shuffling: " + Arrays.toString(logRequest.getResult()));
        return ResponseEntity.ok().build();
    }
} 