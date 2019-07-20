package pl.conectis;

import java.util.Objects;

public class Adreses {

    private String city;
    private String street;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adreses adreses = (Adreses) o;
        return Objects.equals(city, adreses.city) &&
                Objects.equals(street, adreses.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }
}
