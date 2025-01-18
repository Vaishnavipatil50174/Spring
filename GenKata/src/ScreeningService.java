import java.util.Arrays;

public class ScreeningService {
    private static final String API_KEY = "bc9916593fc54489b44ac2bff2d19277";
    private static final String ENDPOINT = "https://api.openai.com";

    public static String screenResume(Resume resume) {
        // Define your criteria for screening
        if (resume.getExperienceYears() < 2) {
            return "Rejected: Not enough experience.";
        }
        if (!Arrays.asList(resume.getSkills()).contains("Java")) {
            return "Rejected: Java skill is required.";
        }
        return "Accepted: The candidate meets the criteria.";
    }

    public static String getExplanation(String screeningResult) {
        // Call to Dial API to generate natural language explanation
        // This is a placeholder for actual API call
        return "Explanation: " + screeningResult;
    }
}