package com.mycompany.app.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Person {

    public Long id;

    @NotBlank(message = "Įveskite pavardę")
    private String pavarde;

    @NotBlank(message = "Įveskite vardą")
    private String vardas;

    @NotBlank(message = "Pasirinkite pareigas")
    private String pareigosID;

    @NotBlank(message = "Pasirinkite lytį")
    private String lytis;

    @NotBlank(message = "Įveskite vaikų skaičių")
    private String vaikai;

    @NotBlank(message = "Nurodykite dokumento galiojimo pradžios datą")
    @DateTimeFormat(pattern = "yyyy-MMM-dd")
    private String data_nuo;
    @NotBlank(message = "Nurodykite dokumento galiojimo pabaigos datą")
    @DateTimeFormat(pattern = "yyyy-MMM-dd")
    private String data_iki;


    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPareigosID() {
        return pareigosID;
    }

    public void setPareigosID(String pareigosID) {
        this.pareigosID = pareigosID;
    }

    public String getLytis() {
        return lytis;
    }

    public void setLytis(String lytis) {
        this.lytis = lytis;
    }

    public String getVaikai() {
        return vaikai;
    }

    public void setVaikai(String vaikai) {
        this.vaikai = vaikai;
    }

    public String getData_nuo() {
        return data_nuo;
    }

    public void setData_nuo(String data_nuo) {
        this.data_nuo = data_nuo;
    }

    public String getData_iki() {
        return data_iki;
    }

    public void setData_iki(String data_iki) {
        this.data_iki = data_iki;
    }
}
