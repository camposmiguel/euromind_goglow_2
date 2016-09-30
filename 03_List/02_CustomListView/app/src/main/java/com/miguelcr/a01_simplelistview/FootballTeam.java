package com.miguelcr.a01_simplelistview;

/**
 * Created by miguelcampos on 30/9/16.
 */

public class FootballTeam {
    private int logo;
    private String name;
    private String city;

    public FootballTeam(int logo, String name, String city) {
        this.logo = logo;
        this.name = name;
        this.city = city;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
