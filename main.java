import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    private Map<Integer, String> contacts = new HashMap<>();

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.processQueries();
    }

    private void processQuery(String type, int number, String name) {
        switch (type) {
            case "add":
                contacts.put(number, name);
                break;
            case "del":
                contacts.remove(number);
                break;
            case "find":
                String response = contacts.getOrDefault(number, "not found");
                System.out.println(response);
                break;
        }
    }

    public void processQueries() {
        Scanner scanner = new Scanner(System.in);
        int queryCount = scanner.nextInt();
        for (int i = 0; i < queryCount; i++) {
            String type = scanner.next();
            int number = scanner.nextInt();
            String name = null;
            if (type.equals("add")) {
                name = scanner.next();
            }
            processQuery(type, number, name);
        }
        scanner.close();
    }
}
