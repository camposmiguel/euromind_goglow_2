package com.miguelcr.a01_simplelistview;

/**
 * Created by miguelcampos on 30/9/16.
 */

public class FootballTeam {
    private String logo;
    private String name;
    private String city;

    public FootballTeam(String logo, String name, String city) {
        this.logo = logo;
        this.name = name;
        this.city = city;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
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
