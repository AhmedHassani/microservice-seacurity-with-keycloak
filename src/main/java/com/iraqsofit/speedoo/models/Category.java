package com.iraqsofit.speedoo.models;

public class Category {
    private int id;
    private String name;
    private String uri;

    public Category(int id, String name, String uri) {
        this.id = id;
        this.name = name;
        this.uri = uri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Category() {
    }


}
