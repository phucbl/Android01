package com.phuocquang.country.model;

public class Country {
    private int urlImage;
    private String mCountry;
    private String mPopulation;

    public Country(int urlImage, String mCountry, String mPopulation) {
        this.urlImage = urlImage;
        this.mCountry = mCountry;
        this.mPopulation = mPopulation;
    }

    public int getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(int urlImage) {
        this.urlImage = urlImage;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmPopulation() {
        return mPopulation;
    }

    public void setmPopulation(String mPopulation) {
        this.mPopulation = mPopulation;
    }
}
