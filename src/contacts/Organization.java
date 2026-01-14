package contacts;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Organization extends Contact {
    private String address;
    private static final List<String> fields = List.of("name", "address", "number");

    public Organization() {
        super();
    }

    public static Organization create() {
        Organization organization = new Organization();

        for (String field : fields) {
            String input = InputHandler.readInfo("[add] Enter the " + field + ": ");
            organization.setField(field, input);
        }

        return organization;
    }

    public void setField(String filed, String input) {
        switch (filed) {
            case "name" -> setName(input);
            case "address" -> setAddress(input);
            case "number" -> setNumber(input);
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getShortInfo() {
        return name;
    }

    @Override
    public String getInfo() {
        return String.format(
                """
                        Organization name: %s
                        Address: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s""",
                name,
                address,
                number != null ? number : "[no data]",
                timeCreated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")),
                timeLastEdit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))
        );
    }

    @Override
    public void edit() {
        String filedName = InputHandler.readInfo("[edit] Select a field (" + fields.toString().replace("[", "").replace("]", "") + "): ");
        String input = InputHandler.readInfo("[edit] Enter " + filedName + ": ");
        setField(filedName, input);
    }
    @Override
    public String getSearchString() {
        return name + address + number;
    }
}
