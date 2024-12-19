package serviceshuffle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ShuffleService {

    private final RestTemplate restTemplate;
    private final Random random = new Random();

    @Value("${service.log.url}")
    private String logServiceUrl;

    @Autowired
    public ShuffleService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public int[] shuffleNumbers(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = i + 1;
        }
        
        // Fisher-Yates algorithm - O(n)
        for (int i = number - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        logRequest(number, array);
        
        return array;
    }

    @Async
    public void logRequest(int input, int[] result) {
        LogRequest logRequest = new LogRequest(input, result);
        try {
            restTemplate.postForObject(logServiceUrl, logRequest, Void.class);
        } catch (Exception e) {
            // Log error but don't fail the main request
            e.printStackTrace();
        }
    }
} 