package ru.job4j.oop;

public class Pacient {
    private String name;
    private String surname;
    private String education;
    private String job;
    private String birthday;

    public Pacient(String name, String surname, String education, String job, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.job = job;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getJob() {
        return job;
    }

    public String getBirthday() {
        return birthday;
    }
}
