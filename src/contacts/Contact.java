package contacts;

public class Contact {
    private String name;
    private String surname;
    private String number;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        if (checkNumber(number)) this.number = number;
        else {
            System.out.println("Wrong number format!");
            this.number = null;
        }
    }

    public boolean checkNumber(String phone) {
        if (!phone.matches("^[+\\d\\s\\-()a-zA-Z]+$")) return false;
        String onlyBrackets = phone.replaceAll("[^()\\s-]", "");
        if (!onlyBrackets.matches("[\\s-]*") && !onlyBrackets.matches("[\\s-]*\\(\\)[\\s-]*")) return false;
        String[] groups = phone.split("[\\s-]{1}");
        if (groups.length == 0) return false;
        if (!groups[0].matches("^\\+?\\(?[a-zA-Z\\d]+\\)?$")) return false;
        if (groups.length > 1 && !groups[1].matches("^\\(?[a-zA-Z\\d]{2,}\\)?$")) return false;
        if (groups.length > 2) {
            for (int i = 2; i < groups.length; i++) {
                if (!groups[i].matches("^[a-zA-Z\\d]{2,}$")) return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        if (number == null) return "[no number]";
        return number;
    }

    public void setNumber(String number) {
        if (checkNumber(number)) this.number = number;
        else {
            System.out.println("Wrong number format!");
            this.number = null;
        }
    }
}
