package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final String STORAGE_FILE;
    private final List<Contact> PHONE_BOOK;

    public PhoneBook(String fileName) {
        this.STORAGE_FILE = "./src/contacts/data/" + fileName;
        new File(STORAGE_FILE).getParentFile().mkdirs();
        this.PHONE_BOOK = load();
        System.out.println("open " + fileName);
        System.out.println();
    }

    private List<Contact> load() {
        File file = new File(STORAGE_FILE);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create file: " + e.getMessage());
            }
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(STORAGE_FILE))) {
            return (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(STORAGE_FILE))) {
            oos.writeObject(PHONE_BOOK);
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public Contact get(int i) {
        return PHONE_BOOK.get(i);
    }
    public List<Contact> getPhoneBook() {
        return PHONE_BOOK;
    }
    public void add(Contact contact) {
        PHONE_BOOK.add(contact);
    }
    public void remove(Contact contact) {
        PHONE_BOOK.remove(contact);
    }
    public int size() {
        return PHONE_BOOK.size();
    }
    public boolean isEmpty() {
        return PHONE_BOOK.isEmpty();
    }
}
