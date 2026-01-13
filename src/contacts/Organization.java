package contacts;

import java.time.format.DateTimeFormatter;

public class Organization extends Contact {
    private String address;

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

    public Organization() {
        super(Type.Organisation);
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
