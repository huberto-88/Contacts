package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final List<Contact> contactList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addNewPerson(String name, String surname, String birthDate, String gender, String phoneNumber) {
        if (!isPhoneNumberValid(phoneNumber)) {
            System.out.println("Wrong number format!");
            phoneNumber = "[no number]";
        }
        contactList.add(
                new Person.ContactCreator()
                        .setName(name)
                        .setSurname(surname)
                        .setBirthDay(birthDate)
                        .setGender(gender)
                        .setPhoneNumber(phoneNumber)
                        .createNewContact()
        );
    }

    public void addNewOrganization(String name, String address, String phoneNumber) {
        if (!isPhoneNumberValid(phoneNumber)) {
            System.out.println("Wrong number format!");
            phoneNumber = "[no number]";
        }
        contactList.add(
                new Organization.ContactCreator()
                        .setName(name)
                        .setAddress(address)
                        .setPhoneNumber(phoneNumber)
                        .createNewContact()
                );
    }

    public int getNumberOfRecords() {
        return contactList.size();
    }

    public void printListOfRecords() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%d. %s\n",
                    i + 1,
                    contactList.get(i).getName()
            );
        }
    }

    public void showInfo(int index) {
        System.out.println(contactList.get(index - 1));
    }

    public void editRecord(int record) {
        if (record > contactList.size()) {
            System.out.println("There is no record with that id");
        } else {
            if (contactList.get(record - 1) instanceof Person) {
                editPerson((Person) contactList.get(record - 1));
            } else if (contactList.get(record - 1) instanceof Organization) {
                editOrganization((Organization) contactList.get(record - 1));
            }

        }
    }

    private boolean isPhoneNumberValid(String number) {
        String regex = "[+]?(\\w+)?(\\s|[-])?([(]\\w{2,}[)])?((\\s|[-])\\w{2,})*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public void removeRecord(int recordToRemove) {
        contactList.remove(recordToRemove);
    }


    private void editPerson(Person person) {
            System.out.println("Select a field (name, surname, birth, gender, number):");
            String fieldToEdit = scanner.nextLine();
            System.out.printf("Enter %s\n", fieldToEdit);
            String newValue = scanner.nextLine();

        switch (fieldToEdit) {
            case "name":
                person.setName(newValue);
                break;
            case "surname":
                person.setSurname(newValue);
                break;
            case "birth":
                person.setBirthDay(newValue);
                break;
            case "gender":
                person.setGender(newValue);
                break;
            case "number":
                if (!isPhoneNumberValid(newValue)) {
                    System.out.println("Wrong number format!");
                    newValue = "[no number]";
                }
                person.setPhoneNumber(newValue);
                break;
        }
    }

    private void editOrganization(Organization organization) {
        System.out.println("Select a field (name, address, number):");
        String fieldToEdit = scanner.nextLine();
        System.out.printf("Enter %s\n", fieldToEdit);
        String newValue = scanner.nextLine();

        switch (fieldToEdit) {
            case "name":
                organization.setName(newValue);
                break;
            case "address":
                organization.setAddress(newValue);
                break;
            case "number":
                organization.setPhoneNumber(newValue);
                break;
        }
    }


    public void search(String search) {
        int counter = 0;
        StringBuilder result = new StringBuilder();
        int j = 1;

        String regex = ".*" + search + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for (Contact contact : contactList) {
            if (contact.search(pattern)) {
                counter++;
                result.append(j + ". " + contact.getShortInfo() + "\n");
                j++;
            }
        }
        System.out.println("Find " + counter + " results:");
        System.out.println(result);
    }

    public void deleteRecord(int recordIndex) {
        contactList.remove(recordIndex);
    }
}
