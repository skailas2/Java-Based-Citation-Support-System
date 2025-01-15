import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CitationList {
    private ArrayList<Citation> listOfCitations;
    private String title;
    private String authority;

    // Default Constructor
    public CitationList() {
        this.listOfCitations = new ArrayList<>();
        this.title = "Chief";
        this.authority = "Barrett";
    }

    // Overloaded Constructor
    public CitationList(String title, String authority) {
        this.listOfCitations = new ArrayList<>();
        this.title = title;
        this.authority = authority;
    }

    // Homework 2 changes - New fields (example)
    // Example: private String locationAuthority;

    // Getters and Setters
    public ArrayList<Citation> getListOfCitations() { return listOfCitations; }
    public void setListOfCitations(ArrayList<Citation> listOfCitations) { this.listOfCitations = listOfCitations; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthority() { return authority; }
    public void setAuthority(String authority) { this.authority = authority; }

    // toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(" ").append(authority).append("\n");
        for (Citation citation : listOfCitations) {
            sb.append(citation.toString()).append("\n");
        }
        return sb.toString();
    }

    // toCSV() method to save all citations to a CSV file
    public void writeCitationFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Citation citation : listOfCitations) {
            writer.write(citation.toCSV());
            writer.newLine();
        }
        writer.close();
    }

    // Homework 2 changes - Example readCitationFile with extra fields
    public void readCitationFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNextLine()) {
            String[] data = fileScanner.nextLine().split(",");
            Person person = new Person(data[4], data[5], data[6], data[7]);
            Citation citation = new Citation(data[1], data[2], data[3], person);
            listOfCitations.add(citation);
        }
        fileScanner.close();
    }

    // Display methods
    public void displayCitationType(String typeOfOffense) {
        for (Citation citation : listOfCitations) {
            if (citation.getTypeOfOffense().equals(typeOfOffense)) {
                System.out.println(citation);
            }
        }
    }

    public void displayCitation(int number) {
        for (Citation citation : listOfCitations) {
            if (citation.getNumber() == number) {
                System.out.println(citation);
                return;
            }
        }
        System.out.println("Citation not found.");
    }

    public void displayCitation(String lastName) {
        for (Citation citation : listOfCitations) {
            if (citation.getPerson().getLastName().equals(lastName)) {
                System.out.println(citation);
            }
        }
    }

    // Adding a new Citation
    public void newCitation(Scanner sc) {
        System.out.print("Enter type of offense (Parking, Speeding, Jaywalking, Inebriated): ");
        String typeOfOffense = sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        System.out.print("Enter date (dd-MMM-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        Person person = new Person(firstName, lastName, address, phoneNumber);
        Citation citation = new Citation(typeOfOffense, description, date, person);
        listOfCitations.add(citation);
    }
}
