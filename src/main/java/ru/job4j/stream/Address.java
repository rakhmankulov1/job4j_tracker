package ru.job4j.stream;

import java.util.Objects;

public class Address implements Comparable {
    private String city;

    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return getHome() == address.getHome()
                && getApartment() == address.getApartment()
                && getCity().equals(address.getCity())
                && getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(),
                getStreet(), getHome(), getApartment());
    }

    @Override
    public int compareTo(Object o) {
        String a = ((Address) o).getCity();
        String b = this.city;
        return b.compareTo(a);
    }
}
