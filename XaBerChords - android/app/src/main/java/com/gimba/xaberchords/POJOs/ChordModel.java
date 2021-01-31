package com.gimba.xaberchords.POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChordModel {

    @SerializedName("Picture")
    @Expose
    private String picture;
    @SerializedName("Information")
    @Expose
    private Object information;
    @SerializedName("Name")
    @Expose
    private String name;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Object getInformation() {
        return information;
    }

    public void setInformation(Object information) {
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}