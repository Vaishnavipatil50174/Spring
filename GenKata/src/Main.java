import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter candidate name:");
        String name = scanner.nextLine();

        System.out.println("Enter skills (comma-separated):");
        String[] skills = scanner.nextLine().split(",");

        System.out.println("Enter years of experience:");
        int experienceYears = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter education:");
        String education = scanner.nextLine();

        System.out.println("Enter certifications (comma-separated):");
        String[] certifications = scanner.nextLine().split(",");

        Resume resume = new Resume(name, skills, experienceYears, education, certifications);
        String screeningResult = ScreeningService.screenResume(resume);
        String explanation = ScreeningService.getExplanation(screeningResult);

        System.out.println("Screening Result: " + screeningResult);
        System.out.println("Explanation: " + explanation);
    }
}