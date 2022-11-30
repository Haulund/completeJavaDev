package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String dateOfBirth;
    private String phoneNumber;

    public Contact(String name, String dateOfBirth, String phoneNumber) throws ParseException{
        if (name == null || name.isBlank() || String.valueOf(phoneNumber).length() < 5) {
            throw new IllegalArgumentException("Invalid args for Contact!");
        }

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.age = toAge(dateOfBirth);
       
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.dateOfBirth = source.dateOfBirth;
        this.phoneNumber = source.phoneNumber;
        this.age = source.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("Invalid name input");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException{
        this.dateOfBirth = dateOfBirth;
        setAge(toAge(dateOfBirth));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (String.valueOf(phoneNumber).length() < 5) {
            throw new IllegalArgumentException("Invalid phone input");
        }
        this.phoneNumber = phoneNumber;
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(dateOfBirth).getTime(); //age in milliseconds
        return (int)TimeUnit.MILLISECONDS.toDays(diff) / 365;
    }

   public String toString() {
    return 
        "Name: " + this.name + "\n" + 
        "Phone number: " + this.phoneNumber + "\n" + 
        "Birth Date: " + this.dateOfBirth + "\n" + 
        "Age: " + this.age + " year old\n";
   }

    


}
