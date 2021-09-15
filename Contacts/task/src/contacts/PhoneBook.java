package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final List<Contact> contactList = new ArrayList<>();

    public void addNewContact(String name, String surname, String phoneNumber) {
        if (!isPhoneNumberValid(phoneNumber)) {
            System.out.println("Wrong number format!");
            phoneNumber = "[no number]";
        }
        contactList.add(
                new Contact.ContactCreator()
                        .setName(name)
                        .setSurname(surname)
                        .setPhoneNumber(phoneNumber)
                        .createNewContact()
        );
    }

    public int getNumberOfRecords() {
        return contactList.size();
    }

    public void printListOfRecords() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%d. %s %s, %s\n",
                    i + 1,
                    contactList.get(i).getName(),
                    contactList.get(i).getSurname(),
                    contactList.get(i).getPhoneNumber()
            );
        }
    }

    public void editRecord(int record, String fieldToEdit, String newValue) {
        if (record > contactList.size()) {
            System.out.println("There is no record with that id");
        } else {
            switch (fieldToEdit) {
                case "name":
                    contactList.get(record - 1).setName(newValue);
                    break;
                case "surname":
                    contactList.get(record - 1).setSurname(newValue);
                    break;
                case "number":
                    if (!isPhoneNumberValid(newValue)) {
                        System.out.println("Wrong number format!");
                        newValue = "[no number]";
                    }
                        contactList.get(record - 1).setPhoneNumber(newValue);
                    break;
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
}
