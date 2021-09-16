package contacts;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact {
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdit;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeCreated = LocalDateTime.now();
        this.timeLastEdit = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public abstract String getShortInfo();

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean search(Pattern pattern) {
        Matcher matcherName = pattern.matcher(name);
        Matcher matcherPhoneNumber = pattern.matcher(phoneNumber);
        return matcherName.matches() || matcherPhoneNumber.matches();
    }
}
