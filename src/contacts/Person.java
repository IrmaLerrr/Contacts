package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person extends Contact {
    private String surname;
    private String birthDate;
    private String gender;

    public Person() {
        super(Type.Person);
    }

    @Override
    public String getShortInfo() {
        return name + " " + surname;
    }

    @Override
    public String getInfo() {
        return String.format(
                """
                        Name: %s
                        Surname: %s
                        Birth date: %s
                        Gender: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s""",
                name,
                surname,
                birthDate != null ? birthDate : "[no data]",
                gender != null ? gender : "[no data]",
                number != null ? number : "[no data]",
                timeCreated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")),
                timeLastEdit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))
        );
    }

    public void setSurname(String surname) {
        this.surname = surname;
        timeLastEdit = LocalDateTime.now();
    }

    public void setBirthDate(String birthDate) {
        try {
            LocalDate.parse(birthDate);
            this.birthDate = birthDate;
        } catch (Exception e) {
            System.out.println("Bad birth date!");
            this.birthDate = null;
        }
        timeLastEdit = LocalDateTime.now();
    }

    public void setGender(String gender) {
        switch (gender.toUpperCase()) {
            case "M" -> this.gender = "M";
            case "F" -> this.gender = "F";
            default -> {
                System.out.println("Bad gender!");
                this.gender = null;
            }
        }
        timeLastEdit = LocalDateTime.now();
    }
}
