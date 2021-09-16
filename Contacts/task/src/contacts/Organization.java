package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Organization extends Contact {
    private String address;

    private Organization(String name, String address, String phoneNumber) {
        super(name, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + timeCreated + "\n" +
                "Time last edit: " + timeLastEdit + "\n";
    }

    @Override
    public String getShortInfo() {
        return name;
    }

    @Override
    public boolean search(Pattern pattern) {
        Matcher matcherAddress = pattern.matcher(address);
        return super.search(pattern) || matcherAddress.matches();
    }

    static class ContactCreator {
        private String name;
        private String address;
        private String phoneNumber;

        ContactCreator setName(String name) {
            this.name = name;
            return this;
        }

        ContactCreator setAddress(String address) {
            this.address = address;
            return this;
        }

        ContactCreator setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        Organization createNewContact() {
            return new Organization(name, address, phoneNumber);
        }
    }
}
