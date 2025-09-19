package com.example.survey;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class SurveyController {

    // Тимчасове зберігання відповідей у пам’яті
    private final List<String> responses = new ArrayList<>();

    @PostMapping("/response")
    public String handleResponse(@RequestBody Map<String, String> payload) {
        String answer = payload.get("answer");
        // Зберігаємо відповідь у списку
        responses.add(answer);
        System.out.println("Користувач обрав: " + answer);
        return "OK";
    }

    @GetMapping("/responses")
    public List<String> getAllResponses() {
        return responses;
    }
}
