package contacts;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    private Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    static class ContactCreator {
        private String name;
        private String surname;
        private String phoneNumber;

        ContactCreator setName(String name) {
            this.name = name;
            return this;
        }

        ContactCreator setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        ContactCreator setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        Contact createNewContact() {
            return new Contact(name, surname, phoneNumber);
        }
    }

}
