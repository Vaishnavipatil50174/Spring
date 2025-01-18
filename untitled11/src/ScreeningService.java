import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;

public class ScreeningService {
    private static final String API_KEY = "bc9916593fc54489b44ac2bff2d19277";
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
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"prompt\":\"" + screeningResult + "\", \"max_tokens\":60}"
                ))
                .build();

        int attempts = 0;
        while (attempts < 3) {
            try {
                System.out.println("Attempt " + (attempts + 1) + " to send request.");
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return parseResponse(response.body());
            } catch (IOException | InterruptedException e) {
                attempts++;
                System.out.println("Attempt failed: " + e.getMessage());
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted");
                }
                if (attempts == 3) {
                    e.printStackTrace();
                    return "Failed to get explanation due to: " + e.getMessage();
                }
            }
        }
        return "Failed to get explanation after multiple attempts.";
    }

    private static String parseResponse(String responseBody) {
        // Placeholder for JSON parsing. Implement according to your API response structure.
        return "API Explanation: " + responseBody;
    }
}