package Java8_9_10_11.jmp_dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class User implements Serializable {

    String name;
    String surname;
    LocalDate birthday;

    //Created this field just to test not serializable field.
    transient int age;

    public User(String userName, String userSurname, LocalDate userBirthDay) {
        name = userName;
        surname = userSurname;
        birthday = userBirthDay;
        age = LocalDate.now().getYear() - userBirthDay.getYear();
    }

    public User(){

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
