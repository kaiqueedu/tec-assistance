package br.edu.dw2.tecassistance.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    private String publicPlace;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String zipCode;

//    public Adress(String publicPlace, String number, String complement, String district, String city, String state, String zopCode) {
//        this.publicPlace = publicPlace;
//        this.number = number;
//        this.complement = complement;
//        this.district = district;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zopCode;
//    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}