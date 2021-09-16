package contacts;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ContactApp {
    private final Scanner scanner = new Scanner(System.in);
    private final PhoneBook phoneBook;

    public ContactApp() {
        this.phoneBook = new PhoneBook();
    }


    public void run() {
        while (true) {
            displayMenu();
        }
    }


    private void displayMenu() {
        System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
        String option = scanner.nextLine().trim();

        switch (option) {
            case "add":
                System.out.print("Enter the type (person, organization):");
                String type = scanner.nextLine().trim();
                if (type.equals("person")) {
                    addPerson();
                } else if (type.equals("organization")) {
                    addOrganization();
                }
                break;
            case "list":
                list();
                System.out.println("[list] Enter action ([number], back): ");
                String action = scanner.nextLine();
                if (action.matches("\\d")) {
                    int recordIndex = Integer.parseInt(action);
                    phoneBook.showInfo(recordIndex);
                    record(recordIndex);
                }
                break;
            case "remove":
                remove();
                break;
            case "count":
                count();
                break;
            case "info":
                info();
                break;
            case "search":
                search();
                break;
            case "exit":
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("There is no option " + option);
                System.out.println("Choose another one");
        }
    }

    private void search() {
        System.out.print("Enter search query: ");
        String search = scanner.nextLine();
        phoneBook.search(search);

        System.out.print("[search] Enter action ([number], back, again):");
        String nextAction = scanner.nextLine();
        if (nextAction.equals("again")) {
            search();
        } else if (nextAction.equals("back")) {
            return;
        } else if (nextAction.matches("\\d+")) {
            int recordIndex = Integer.parseInt(nextAction);
            phoneBook.showInfo(recordIndex);
            record(recordIndex);
        }
    }

    private void record(int recordIndex) {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String option = scanner.nextLine();

        if (option.equals("edit")) {
            edit(recordIndex);
        } else if (option.equals("delete")) {
            delete(recordIndex);
        } else if (option.equals("menu")) {
            displayMenu();
        }

    }

    private void delete(int recordIndex) {
        phoneBook.deleteRecord(recordIndex);
    }

    private void count() {
        System.out.printf("The Phone Book has %d records.\n", phoneBook.getNumberOfRecords());
    }

    private void info() {
        phoneBook.printListOfRecords();
        System.out.print("Enter index to show info: ");
        int index = Integer.parseInt(scanner.nextLine().trim());
        phoneBook.showInfo(index);
    }

    private void addPerson() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter the birth date: ");
        String birthDate = scanner.nextLine();
        if (!checkBirthDate(birthDate)) {
            birthDate = "[no data]";
        }

        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine().trim();
        if (!gender.matches("[FM]")) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }

        System.out.println("Enter the number");
        String number = scanner.nextLine();

        phoneBook.addNewPerson(name, surname, birthDate, gender, number);
        System.out.println("The record added.");
    }


    private void addOrganization() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number");
        String number = scanner.nextLine();

        phoneBook.addNewOrganization(name, address, number);
        System.out.println("The record added.");
    }

    private void remove() {
        if (phoneBook.getNumberOfRecords() < 1) {
            System.out.println("No records to remove!");
        } else {
            list();
            System.out.println("Select a record:");
            int recordToRemove = Integer.parseInt(scanner.nextLine().trim());
            phoneBook.removeRecord(recordToRemove);
            System.out.println("The record removed!");
        }
    }

    private void list() {
        phoneBook.printListOfRecords();
    }

    private void edit(int recordIndex) {
        if (phoneBook.getNumberOfRecords() < 1) {
            System.out.println("No records to edit!");
        } else {
            phoneBook.editRecord(recordIndex);
            System.out.println("The record updated!\n");
        }
    }

    private boolean checkBirthDate(String birthDate) {
        try {
            LocalDate test = LocalDate.parse(birthDate);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
            return false;
        }
    }
}