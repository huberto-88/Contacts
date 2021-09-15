package contacts;

public class Organization extends Contact {
    private String address;

    public Organization(String name, String address, String phoneNumber) {
        super(name, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    static class ContactCreator {
        private String name;
        private String address;
        private String phoneNumber;

        public ContactCreator(String name, String address, String phoneNumber) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

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
