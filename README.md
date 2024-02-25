# skateboard-park-api

---

# Skateboard Park API Communication Contract

**Introduction**

The Skateboard Park API microservice provides endpoints for requesting and receiving data about skateboard parks.

**Requesting Data**

To request data from the Skateboard Park API microservice, follow these steps:

- Endpoint URL: http://localhost:8080/skateboard-park.
- HTTP Method: Use the HTTP GET method to request data from the microservice.
- Sending the Request: Send an HTTP GET request to the endpoint URL using your preferred HTTP client library or tool.
- Handling Response: Handle the response returned by the microservice (contains requested data in JSON format).

**Example Request**
```
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class SkateboardParkAPITest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        // Define the URL of the endpoint to retrieve skateboard parks
        String url = "http://localhost:8080/skateboard-park";

        // Make a GET request to the microservice
        String jsonResponse = restTemplate.getForObject(url, String.class);

        // Handle the response (deserialize JSON, process data, etc.)
        // Example handling shown in the accompanying code.
    }
}
```

**Receiving Data**

The Skateboard Park API microservice responds to requests with data in JSON format. When receiving data from the microservice, follow these steps:

- Handling Response: Receive the JSON response from the microservice.
- Deserialization: Deserialize the JSON response into appropriate data objects in your programming language. This step may involve using JSON parsing libraries or frameworks.
- Processing Data: Process the received data as needed for your application logic.

**Example Handling**
```
import com.fasterxml.jackson.databind.ObjectMapper;

  // Assuming SkateboardPark class is defined to represent skateboard park data

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

```
