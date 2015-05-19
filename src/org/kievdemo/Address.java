package org.kievdemo;

public class Address {
    private String street;
    private short buildingNumber;

    public Address(String street, short buildingNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (buildingNumber != address.buildingNumber) return false;
        return !(street != null ? !street.equals(address.street) : address.street != null);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (int) buildingNumber;
        return result;
    }
}