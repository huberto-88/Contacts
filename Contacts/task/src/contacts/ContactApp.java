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
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
        String option = scanner.nextLine().trim();

        switch (option) {
            case "add":
                System.out.println("Enter the type (person, organization:");
                String type = scanner.nextLine().trim();
                if (type.equals("person")) {
                    addPerson();
                } else if (type.equals("organization")) {
                    addOrganization();
                }
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
            case "info":
                info();
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
        System.out.println("The record added.\n");
    }


    private void addOrganization() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number");
        String number = scanner.nextLine();

        phoneBook.addNewOrganization(name, address, number);
        System.out.println("The record added.\n");
    }

    private void remove() {
        if (phoneBook.getNumberOfRecords() < 1) {
            System.out.println("No records to remove!");
        } else {
           // list();
            System.out.println("Select a record:");
            int recordToRemove = Integer.parseInt(scanner.nextLine().trim()) - 1;
            phoneBook.removeRecord(recordToRemove);
            System.out.println("The record removed!");
        }
    }

    private void edit() {
        if (phoneBook.getNumberOfRecords() < 1) {
            System.out.println("No records to edit!");
        } else {
            phoneBook.printListOfRecords();
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine().trim());

            phoneBook.editRecord(record);
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