public class Resume {
    private String name;
    private String[] skills;
    private int experienceYears;
    private String education;
    private String[] certifications;

    public Resume(String name, String[] skills, int experienceYears, String education, String[] certifications) {
        this.name = name;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.education = education;
        this.certifications = certifications;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getEducation() {
        return education;
    }

    public String[] getCertifications() {
        return certifications;
    }
}