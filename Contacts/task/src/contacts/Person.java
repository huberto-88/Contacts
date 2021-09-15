package contacts;

import java.time.LocalDate;

public class Person extends Contact {
    private String surname;
    private String gender;
    private LocalDate birthDay;

    private Person(String name, String surname, String gender, LocalDate birthDay, String phoneNumber) {
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }



    static class ContactCreator {
        private String name;
        private String surname;
        private String gender;
        private LocalDate birthDay;
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

        ContactCreator setBirthDay(LocalDate birthDay) {
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
