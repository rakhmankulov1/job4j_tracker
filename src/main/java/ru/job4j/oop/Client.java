package ru.job4j.oop;

public class Client {
    private String companyName;
    private String companyRepresentative;
    private String deadLine;

    public Client(String companyName, String companyRepresentative, String deadLine) {
        this.companyName = companyName;
        this.companyRepresentative = companyRepresentative;
        this.deadLine = deadLine;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyRepresentative() {
        return companyRepresentative;
    }

    public String getDeadLine() {
        return deadLine;
    }
}
