package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String dateOfBirth;
    private int phoneNumber;

    public Contact(String name, String dateOfBirth, int phoneNumber) throws ParseException{
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        long diff = new Date().getTime() - formatter.parse(dateOfBirth).getTime(); //age in milliseconds
        this.age = (int)TimeUnit.MILLISECONDS.toDays(diff) / 365;

    }


}
