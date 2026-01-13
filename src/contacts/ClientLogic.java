package contacts;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientLogic {
    Scanner scanner = new Scanner(System.in);
    List<Contact> phoneBook = new ArrayList<>();

    public void start() {
//        Contact contact = new Contact("name", "surname", "+0 (123) 456-789-ABcd");
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            String option = scanner.nextLine().trim();
            switch (option) {
                case "add" -> add();
                case "remove" -> remove();
                case "edit" -> edit();
                case "count" -> count();
                case "list" -> list();
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Error! Command not recognized, please, try again");
            }
        }
    }

    public void add() {
        System.out.print("Enter the name of the person:");
        String name = scanner.nextLine().trim();
        System.out.print("Enter the surname of the person:");
        String surname = scanner.nextLine().trim();
        System.out.print("Enter the number:");
        String number = scanner.nextLine().trim();
        Contact contact = new Contact(name, surname, number);
        phoneBook.add(contact);
        System.out.println("A record created!");
    }

    public void remove() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            printPhoneBook();
            System.out.println("Select a record: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")
                    && Integer.parseInt(input) >= 0
                    && Integer.parseInt(input) <= phoneBook.size()) {
                int i = Integer.parseInt(input) - 1;
                phoneBook.remove(i);
                System.out.println("A record removed!");
            } else {
                System.out.println("Error! Number of record not recognized, please, try again");
            }

        }
    }

    public void edit() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            printPhoneBook();
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")
                    && Integer.parseInt(input) >= 0
                    && Integer.parseInt(input) <= phoneBook.size()) {
                System.out.print("Select a field (name, surname, number): ");
                String input2 = scanner.nextLine().trim();
                int i = Integer.parseInt(input) - 1;
                switch (input2.toLowerCase()) {
                    case "name" -> {
                        System.out.print("Enter name: ");
                        String input3 = scanner.nextLine().trim();
                        phoneBook.get(i).setName(input3);
                        System.out.println("The record updated!");
                    }
                    case "surname" -> {
                        System.out.print("Enter surname: ");
                        String input3 = scanner.nextLine().trim();
                        phoneBook.get(i).setSurname(input3);
                        System.out.println("The record updated!");
                    }
                    case "number" -> {
                        System.out.print("Enter number: ");
                        String input3 = scanner.nextLine().trim();
                        phoneBook.get(i).setNumber(input3);
                        System.out.println("The record updated!");
                    }
                    default -> System.out.println("Error! Field not recognized!");
                }

            } else {
                System.out.println("Error! Number of record not recognized!");
            }
        }
    }

    public void count() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }

    public void list() {
        printPhoneBook();
    }

    private void printPhoneBook() {
        for (int i = 0; i < phoneBook.size(); i++) {
            Contact contact = phoneBook.get(i);
            System.out.printf("%d. %s %s, %s\n",
                    i + 1,
                    contact.getName(),
                    contact.getSurname(),
                    contact.getNumber()
            );
        }
    }
}
