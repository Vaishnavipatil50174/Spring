//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter candidate name:");
//        String name = scanner.nextLine();
//
//        System.out.println("Enter skills (comma-separated):");
//        String[] skills = scanner.nextLine().split(",");
//
//        System.out.println("Enter years of experience:");
//        int experienceYears = Integer.parseInt(scanner.nextLine());
//
//        System.out.println("Enter education:");
//        String education = scanner.nextLine();
//
//        System.out.println("Enter certifications (comma-separated):");
//        String[] certifications = scanner.nextLine().split(",");
//
//        Resume resume = new Resume(name, skills, experienceYears, education, certifications);
//        String screeningResult = ScreeningService.screenResume(resume);
//        String explanation = ScreeningService.getExplanation(screeningResult);
//
//        System.out.println("Screening Result: " + screeningResult);
//        System.out.println("Explanation: " + explanation);
//    }
//}

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String ENDPOINT = "https://ai-proxy.lab.epam.com";
    private static final String API_KEY = "bc9916593fc54489b44ac2bff2d19277 ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collecting candidate information
        System.out.println("Enter candidate name:");
        String name = scanner.nextLine();

        System.out.println("Enter skills (comma-separated):");
        String skills = scanner.nextLine();

        System.out.println("Enter years of experience:");
        int years = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter education:");
        String education = scanner.nextLine();

        System.out.println("Enter certifications (comma-separated):");
        String certifications = scanner.nextLine();

        // Constructing a screening result
        String screeningResult = String.format("Name: %s, Skills: %s, Experience: %d years, Education: %s, Certifications: %s",
                name, skills, years, education, certifications);

        // Getting explanation from an external API
        String explanation = getExplanation(screeningResult);
        System.out.println("Explanation: " + explanation);

        scanner.close();
    }

    public static String getExplanation(String screeningResult) {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString("{\"prompt\":\"" + screeningResult + "\", \"max_tokens\":60}"))
                .build();

        int attempts = 0;
        long waitTimeInMillis = 1000; // Initial wait time of 1 second

        while (attempts < 3) {
            try {
                System.out.println("Sending HTTP request, attempt " + (attempts + 1));
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response received: " + response.body());
                return parseResponse(response.body());
            } catch (IOException | InterruptedException e) {
                System.out.println("Attempt " + (attempts + 1) + " failed: " + e.getMessage());
                attempts++;
                if (attempts >= 3) {
                    e.printStackTrace();
                    return "Failed to get explanation due to: " + e.getMessage();
                }
                try {
                    Thread.sleep(waitTimeInMillis);
                    waitTimeInMillis *= 2; // Double the wait time for the next retry
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return "Failed to get explanation due to interruption.";
                }
            }
        }
        return "Failed to get explanation after multiple attempts.";
    }

    private static String parseResponse(String responseBody) {
        // Implement your response parsing logic here
        return responseBody; // Placeholder return
    }
}