package contacts;

import java.time.LocalDate;

public class Person extends Contact {
    private String surname;
    private String gender;
    private String birthDay;

    private Person(String name, String surname, String gender, String birthDay, String phoneNumber) {
        super(name, phoneNumber);
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthDay + "\n" +
                "Gender: " + gender + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + timeCreated + "\n" +
                "Time last edit: " + timeLastEdit + "\n";
    }

    static class ContactCreator {
        private String name;
        private String surname;
        private String gender;
        private String birthDay;
        private String phoneNumber;

        ContactCreator setName(String name) {
            this.name = name;
            return this;
        }

        ContactCreator setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        ContactCreator setGender(String gender) {
            this.gender = gender;
            return this;
        }

        ContactCreator setBirthDay(String birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        ContactCreator setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        Person createNewContact() {
            return new Person(name, surname, gender, birthDay, phoneNumber);
        }
    }

}
