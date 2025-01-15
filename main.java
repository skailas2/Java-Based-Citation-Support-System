import java.io.IOException;
import java.util.Scanner;

public class hw1Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CitationList citationList = new CitationList();

        // Load citation data from CSV file
        try {
            citationList.readCitationFile("C:/Users/shrey/Downloads/javahw1/citations.csv");
        } catch (IOException e) {
            System.err.println("Error reading citation file: " + e.getMessage());
            return; // Exit if file reading fails
        }

        // Main menu loop
        int choice;
        do {
            choice = Menu.displayMenu(sc);

            switch (choice) {
                case 1:
                    System.out.println(citationList.toString());
                    break;

                case 2:
                    System.out.print("Enter type of offense (Parking, Speeding, Jaywalking, Inebriated): ");
                    String offenseType = sc.nextLine().trim();
                    citationList.displayCitationType(offenseType);
                    break;

                case 3:
                    try {
                        System.out.print("Enter citation number: ");
                        int citationNumber = Integer.parseInt(sc.nextLine());
                        citationList.displayCitation(citationNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid citation number. Please enter a valid number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the last name of the person: ");
                    String lastName = sc.nextLine().trim();
                    citationList.displayCitation(lastName);
                    break;

                case 5:
                    citationList.writeCitationFile("temp");
                    break;

                case 0:
                    System.out.println("Exiting and saving data...");
                    try {
                        citationList.writeCitationFile("citations.csv");
                    } catch (IOException e) {
                        System.err.println("Error writing citation file: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
