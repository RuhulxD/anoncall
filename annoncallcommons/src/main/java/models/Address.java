package models;

public class Address {
    String countryCode;
    String City;

    public Address() {
    }

    public Address(String countryCode, String city) {
        this.countryCode = countryCode;
        City = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
