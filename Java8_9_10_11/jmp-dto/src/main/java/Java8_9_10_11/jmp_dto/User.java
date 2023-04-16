package Java8_9_10_11.jmp_dto;

import java.time.LocalDate;

public class User {

    String name;
    String surname;
    LocalDate birthday;

    public User(String userName, String userSurname, LocalDate userBirthDay) {
        name = userName;
        surname = userSurname;
        birthday = userBirthDay;
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
