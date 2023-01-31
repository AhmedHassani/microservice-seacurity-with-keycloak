package com.iraqsofit.speedoo.models;


import javax.persistence.*;

@Entity
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,name = "id")
    private long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String type;


    public Media(String path, String type) {
        this.path = path;
        this.type = type;
    }

    public Media() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
