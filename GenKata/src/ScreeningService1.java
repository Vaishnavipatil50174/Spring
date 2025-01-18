import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.util.Arrays;

public class ScreeningService1 {
    private static final String API_KEY = "bc9916593fc54489b44ac2bff2d19277 ";
    private static final String ENDPOINT = "https://ai-proxy.lab.epam.com";

    public static String screenResume(Resume resume) {
        if (resume.getExperienceYears() < 2) {
            return "Rejected: Not enough experience.";
        }
        if (!Arrays.asList(resume.getSkills()).contains("Java")) {
            return "Rejected: Java skill is required.";
        }
        return "Accepted: The candidate meets the criteria.";
    }

    public static String getExplanation(String screeningResult) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"prompt\":\"" + screeningResult + "\",\"max_tokens\":60}"
                ))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response.body());
        } catch (IOException e) {
            e.printStackTrace();
            return "Network error: Failed to connect to API - " + e.getMessage();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Properly handle thread interruption
            e.printStackTrace();
            return "Request interrupted: Failed to get explanation from API - " + e.getMessage();
        } catch (Exception e) { // Catch-all block should ideally be avoided unless necessary
            e.printStackTrace();
            return "Unexpected error: " + e.getMessage();
        }
    }

    private static String parseResponse(String responseBody) {
        // Assuming the response is a simple JSON with a key 'choices' containing the explanation
        // This is a placeholder to parse the JSON response
        return "API Explanation: " + responseBody; // Modify this according to the actual JSON structure
    }
}
