package com.example.skateboardparkapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class SkateboardParkAPITest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        // Define the URL of the endpoint to retrieve skateboard parks
        String url = "http://localhost:8080/skateboard-park";

        // Make a GET request to the microservice
        String jsonResponse = restTemplate.getForObject(url, String.class);

        // Deserialize JSON response into SkateboardPark array
        ObjectMapper mapper = new ObjectMapper();
        try {
            SkateboardPark[] skateboardParks = mapper.readValue(jsonResponse, SkateboardPark[].class);

            // Process or utilize skateboardParks array
            for (SkateboardPark park : skateboardParks) {
                System.out.println("Skateboard Park: " + park.getName() + ", Location: " + park.getLocation());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


