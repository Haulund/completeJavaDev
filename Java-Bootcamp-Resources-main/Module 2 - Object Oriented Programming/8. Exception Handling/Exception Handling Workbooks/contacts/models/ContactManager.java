package models;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacs;

    public ContactManager() {
        this.contacs = new ArrayList<Contact>();
    }

    public Contact getContact(int index) {
        return new Contact(contacs.get(index));
    }

    public void setContact(int index, Contact contact) {
        contacs.set(index, new Contact(contact));
    }

    public void addContact(Contact contact){
        contacs.add(new Contact(contact));
    }

    public void removeContact(String contactName) {
        if (contacs.isEmpty()) {
            throw new IllegalStateException("Cannot remove contacs in an empty manager");
        }
        for (int i = 0; i < this.contacs.size(); i++) {
            if (contacs.get(i).getName().equals(contactName)) {
                contacs.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (Contact contac : contacs) {
            temp += contac.toString() + "\n";
        }
        return temp;
    }
}
