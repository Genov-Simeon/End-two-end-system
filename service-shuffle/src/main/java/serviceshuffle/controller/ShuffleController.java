package serviceshuffle.controller;

import serviceshuffle.service.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShuffleController {

    private final ShuffleService shuffleService;

    @Autowired
    public ShuffleController(ShuffleService shuffleService) {
        this.shuffleService = shuffleService;
    }

    @PostMapping("/shuffle")
    public ResponseEntity<int[]> shuffleNumbers(@RequestBody int number) {
        if (number < 1 || number > 1000) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(shuffleService.shuffleNumbers(number));
    }
} 