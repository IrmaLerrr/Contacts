package contacts;

import java.time.LocalDateTime;

abstract public class Contact {
    private final Type type;
    protected String name;
    protected String number;
    protected LocalDateTime  timeCreated;
    protected LocalDateTime timeLastEdit;


    public abstract String getShortInfo();
    public abstract String getInfo();

    public Contact(Type type) {
        this.type = type;
        timeCreated = LocalDateTime.now();
        timeLastEdit = LocalDateTime.now();
    }

    public Type getType() {
        return type;
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

    public void setName(String name) {
        this.name = name;
        timeLastEdit = LocalDateTime.now();
    }

    public void setNumber(String number) {
        if (checkNumber(number)) this.number = number;
        else {
            System.out.println("Wrong number format!");
            this.number = null;
        }
        timeLastEdit = LocalDateTime.now();
    }
}
