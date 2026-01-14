package contacts;

import java.util.ArrayList;
import java.util.List;

public class ClientLogic {
    PhoneBook phoneBook;

    public ClientLogic(String fileName) {
        this.phoneBook = new PhoneBook(fileName);
    }

    public void start() {
        while (true) {
            String option = InputHandler.readInfo("[menu] Enter action (add, list, search, count, exit): ");
            switch (option.toLowerCase()) {
                case "add" -> add();
                case "list" -> list();
                case "count" -> count();
                case "search" -> search();
                case "exit" -> {
                    return;
                }
                default -> {
                    System.out.println("Error! Command not recognized.");
                    System.out.println();
                }
            }
        }
    }

    public void add() {
        String option = InputHandler.readInfo("[add] Enter the type (person, organization): ");
        Contact contact;
        switch (option) {
            case "person" -> contact = Person.create();
            case "organization" -> contact = Organization.create();
            default -> {
                System.out.println("Error! Command not recognized.");
                return;
            }
        }
        phoneBook.add(contact);
        phoneBook.save();
        System.out.println("The record added.");
        System.out.println();
    }

    public void remove(Contact contact) {
        phoneBook.remove(contact);
        phoneBook.save();
        System.out.println("The record removed!");
        System.out.println();
    }


    public void edit(Contact contact) {
        contact.edit();
        phoneBook.save();
        System.out.println("The record updated!");
        System.out.println();
    }

    public void count() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }

    public void record(Contact contact) {
        String input = InputHandler.readInfo("[record] Enter action (edit, delete, menu, back): ");
        switch (input.toLowerCase()) {
            case "delete" -> remove(contact);
            case "edit" -> edit(contact);
            case "back" -> list();
            case "menu" -> System.out.println();
            default -> System.out.println("Error! Command not recognized.");
        }
    }

    public void list() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to show!");
        } else {
            print(phoneBook.getPhoneBook());
            String input = InputHandler.readInfo("[list] Enter action ([number], back): ");
            if (input.equals("back")) {
                System.out.println();
            } else if (checkNumber(input, phoneBook.getPhoneBook())) {
                int i = Integer.parseInt(input) - 1;
                Contact contact = phoneBook.get(i);
                System.out.println(contact.getInfo());
                System.out.println();
                record(contact);
            } else {
                System.out.println("Error! Command not recognized!");
            }
        }

    }

    public void search() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            String input = InputHandler.readInfo("Enter search query: ").toLowerCase();
            List<Contact> list = new ArrayList<>();
            for (Contact contact : phoneBook.getPhoneBook()) {
                if (contact.getSearchString().toLowerCase().contains(input)) list.add(contact);
            }
            System.out.println("Found " + list.size() + " results:");
            print(list);
            System.out.println();

            String action = InputHandler.readInfo("[search] Enter action ([number], back, again): ").toLowerCase();
            switch (action) {
                case "back" -> System.out.println();
                case "again" -> search();
                default -> {
                    if (checkNumber(action, list)) {
                        int i = Integer.parseInt(action) - 1;
                        Contact contact = list.get(i);
                        System.out.println(contact.getInfo());
                        System.out.println();
                        record(contact);
                    } else {
                        System.out.println("Error! Command not recognized!");
                    }

                }
            }
        }
    }

    private void print(List<Contact> list) {
        for (int i = 0; i < list.size(); i++) {
            Contact contact = list.get(i);
            System.out.printf("%d. %s\n",
                    i + 1,
                    contact.getShortInfo()
            );
        }
    }

    private boolean checkNumber(String number, List<Contact> list) {
        return number.matches("\\d+")
                && Integer.parseInt(number) >= 0
                && Integer.parseInt(number) <= list.size();
    }
}

