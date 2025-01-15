import java.util.Scanner;

public class Menu {
    private static final String[] menuChoices = {
        "0. Quit.",
        "1. Display all Citation data.",
        "2. Display Citations by offense type.",
        "3. Search for a Citation by number.",
        "4. Search for a Citation by Person's last name.",
        "5. Add a new Citation."
    };

    public static int displayMenu(Scanner sc) {
        for (String choice : menuChoices) {
            System.out.println(choice);
        }
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
