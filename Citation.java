public class Citation {
    private static int citationCounter = 1; // for unique citation numbers
    private int number;
    private String typeOfOffense;
    private String description;
    private String date;
    private Person person;

    // Default Constructor
    public Citation() {
        this.number = citationCounter++;
    }

    // Overloaded Constructor
    public Citation(String typeOfOffense, String description, String date, Person person) {
        this.number = citationCounter++;
        this.typeOfOffense = typeOfOffense;
        this.description = description;
        this.date = date;
        this.person = person;
    }

    // Homework 2 changes - New fields (examples)
    // Example: private String location; // for offense location, if needed

    // Getters and Setters
    public int getNumber() { return number; }
    public String getTypeOfOffense() { return typeOfOffense; }
    public void setTypeOfOffense(String typeOfOffense) { this.typeOfOffense = typeOfOffense; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    // toString() method
    @Override
    public String toString() {
        return "Citation #" + number + "\nType Of Offense: " + typeOfOffense +
                "\nDescription: " + description +
                "\nDate: " + date +
                "\nPerson: " + person.toString() + "\n";
    }

    // toCSV() method
    public String toCSV() {
        return number + "," + typeOfOffense + "," + description + "," + date + "," + 
                person.getFirstName() + "," + person.getLastName() + "," + 
                person.getAddress() + "," + person.getPhoneNumber();
    }

    // Homework 2 changes - Example additional methods
    // public String getLocation() { return location; }
    // public void setLocation(String location) { this.location = location; }
}
