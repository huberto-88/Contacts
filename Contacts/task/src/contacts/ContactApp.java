package contacts;

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
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        String option = scanner.nextLine().trim();

        switch (option) {
            case "add":
                add();

                break;
            case "remove":
                remove();

                break;
            case "edit":
                edit();

                break;
            case "count":
                count();
                break;
            case "list":
                list();

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

    private void count() {
        System.out.printf("The Phone Book has %d records.\n", phoneBook.getNumberOfRecords());
    }

    private void list() {
        phoneBook.printListOfRecords();
    }

    private void add() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number");
        String number = scanner.nextLine();

        phoneBook.addNewContact(name, surname, number);
        System.out.println("The record added.");
    }

    private void remove() {
        if (phoneBook.getNumberOfRecords() < 1) {
            System.out.println("No records to remove!");
        } else {
            list();
            System.out.println("Select a record:");
            int recordToRemove = Integer.valueOf(scanner.nextLine().trim()) - 1;
            phoneBook.removeRecord(recordToRemove);
            System.out.println("The record removed!");
        }
    }

    private void edit() {
        if (phoneBook.getNumberOfRecords() < 1) {
            System.out.println("No records to edit!");
        } else {
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Select a field (name, surname, number):");
            String fieldToEdit = scanner.nextLine();
            System.out.printf("Enter %s\n", fieldToEdit);
            String newValue = scanner.nextLine();

            phoneBook.editRecord(record, fieldToEdit, newValue);
            System.out.println("The record updated!");
        }
    }

}