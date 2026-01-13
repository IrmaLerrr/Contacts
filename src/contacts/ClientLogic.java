package contacts;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientLogic {
    Scanner scanner = new Scanner(System.in);
    List<Contact> phoneBook = new ArrayList<>();

    public void start() {
        while (true) {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String option = scanner.nextLine().trim();
            switch (option) {
                case "add" -> add();
                case "remove" -> remove();
                case "edit" -> edit();
                case "count" -> count();
                case "info" -> info();
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Error! Command not recognized, please, try again");
            }
        }
    }

    public void add() {
        System.out.print("Enter the type (person, organization): ");
        String option = scanner.nextLine().trim().toLowerCase();
        switch (option) {
            case "person" -> addPerson();
            case "organization" -> addOrganisation();
            default -> System.out.println("Error! Command not recognized, please, try again");
        }

    }

    public void addPerson() {
        Contact contact = new Person();

        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine().trim();
        contact.setName(name);

        System.out.print("Enter the surname of the person: ");
        String surname = scanner.nextLine().trim();
        ((Person) contact).setSurname(surname);

        System.out.print("Enter the birth date: ");
        String birthDate = scanner.nextLine().trim();
        ((Person) contact).setBirthDate(birthDate);

        System.out.print("Enter the gender : ");
        String gender = scanner.nextLine().trim();
        ((Person) contact).setGender(gender);

        System.out.print("Enter the number: ");
        String number = scanner.nextLine().trim();
        contact.setNumber(number);

        phoneBook.add(contact);
        System.out.println("The record added.");
        System.out.println();
    }

    public void addOrganisation() {
        Contact contact = new Organization();

        System.out.print("Enter the organization name: ");
        String name = scanner.nextLine().trim();
        contact.setName(name);

        System.out.print("Enter the address: ");
        String address = scanner.nextLine().trim();
        ((Organization) contact).setAddress(address);

        System.out.print("Enter the number: ");
        String number = scanner.nextLine().trim();
        contact.setNumber(number);

        phoneBook.add(contact);
        System.out.println("The record added.");
        System.out.println();
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
                System.out.println("The record removed!");
                System.out.println();
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
                int i = Integer.parseInt(input) - 1;
                Contact contact = phoneBook.get(i);
                switch (contact.getType()) {
                    case Person -> editPerson((Person) contact);
                    case Organisation -> editOrganization((Organization) contact);
                }
            } else {
                System.out.println("Error! Number of record not recognized!");
            }
        }
    }

    public void editPerson(Person contact) {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String option = scanner.nextLine().trim();
        switch (option.toLowerCase()) {
            case "name" -> {
                System.out.println("Enter name: ");
                String input = scanner.nextLine().trim();
                contact.setName(input);
            }
            case "surname" -> {
                System.out.println("Enter surname: ");
                String input = scanner.nextLine().trim();
                contact.setSurname(input);
            }
            case "number" -> {
                System.out.println("Enter number: ");
                String input = scanner.nextLine().trim();
                contact.setNumber(input);
            }
            case "birth" -> {
                System.out.println("Enter birth date: ");
                String input = scanner.nextLine().trim();
                contact.setBirthDate(input);
            }
            case "gender" -> {
                System.out.println("Enter gender: ");
                String input = scanner.nextLine().trim();
                contact.setGender(input);
            }
            default -> {
                System.out.println("Error! Field not recognized!");
                return;
            }
        }
        System.out.println("The record updated!");
        System.out.println();
    }

    public void editOrganization(Organization contact) {
        System.out.println("Select a field (name, address, number): ");
        String option = scanner.nextLine().trim();
        switch (option.toLowerCase()) {
            case "name" -> {
                System.out.println("Enter name: ");
                String input = scanner.nextLine().trim();
                contact.setName(input);
            }
            case "address" -> {
                System.out.println("Enter address: ");
                String input = scanner.nextLine().trim();
                contact.setAddress(input);
            }
            case "number" -> {
                System.out.println("Enter number: ");
                String input = scanner.nextLine().trim();
                contact.setNumber(input);
            }
            default -> {
                System.out.println("Error! Field not recognized!");
                return;
            }
        }
        System.out.println("The record updated!");
        System.out.println();
    }

    public void count() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }

    public void info() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            printPhoneBook();
            System.out.print("Enter index to show info: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")
                    && Integer.parseInt(input) >= 0
                    && Integer.parseInt(input) <= phoneBook.size()) {
                int i = Integer.parseInt(input) - 1;
                Contact contact = phoneBook.get(i);
                System.out.println(contact.getInfo());
                System.out.println();
            } else {
                System.out.println("Error! Number of record not recognized!");
            }
        }
    }

    private void printPhoneBook() {
        for (int i = 0; i < phoneBook.size(); i++) {
            Contact contact = phoneBook.get(i);
            System.out.printf("%d. %s\n",
                    i + 1,
                    contact.getShortInfo()
            );
        }
    }
}

