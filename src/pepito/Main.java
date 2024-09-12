import java.util.Scanner;

class Application {
    int id;
    String name;
    double gpa;
    int annualFamilyIncome;
    int communityServiceHours;
    String scholarshipStatus;

    public Application(int id, String name, double gpa, int annualFamilyIncome, int communityServiceHours) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.annualFamilyIncome = annualFamilyIncome;
        this.communityServiceHours = communityServiceHours;
        this.scholarshipStatus = determineScholarshipStatus();
    }

    public boolean isValid() {
        return gpa >= 0 && gpa <= 4.0 && annualFamilyIncome >= 0 && communityServiceHours >= 0;
    }

    private String determineScholarshipStatus() {
        return gpa >= 3.5 ? "APPROVED" : "DENIED";
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, GPA: %.1f, Annual Family Income: P%,d.00, Community Service Hours: %d, Scholarship Status: %s",
                id, name, gpa, annualFamilyIncome, communityServiceHours, scholarshipStatus);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of Applications: ");
        int numberOfApplications = scanner.nextInt();
        scanner.nextLine(); 

        Application[] applications = new Application[numberOfApplications];

        for (int i = 0; i < numberOfApplications; i++) {
            System.out.println("Enter details of application " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();
            System.out.print("Annual Family Income: ");
            int annualFamilyIncome = scanner.nextInt();
            System.out.print("Community Service Hours: ");
            int communityServiceHours = scanner.nextInt();

            applications[i] = new Application(id, name, gpa, annualFamilyIncome, communityServiceHours);

            if (!applications[i].isValid()) {
                System.out.println("Invalid details for application " + (i + 1));
            }
        }

        System.out.println("\nApplication Details:");
        System.out.println("ID\tNAME\tGPA\tANNUAL FAMILY INCOME\tCOMMUNITY SERVICE HOURS\tSCHOLARSHIP STATUS");
        for (Application app : applications) {
            System.out.println(app);
        }

        scanner.close();
    }
}

