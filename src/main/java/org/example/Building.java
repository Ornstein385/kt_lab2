package org.example;

import java.util.Objects;

public class Building {
    public final String city, street;
    public final int house, floor;

    public Building(String city, String street, int house, int floor) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return house == building.house && floor == building.floor && Objects.equals(city, building.city) && Objects.equals(street, building.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, floor);
    }

    @Override
    public String toString() {
        return "Building{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", floor=" + floor +
                '}';
    }
}
