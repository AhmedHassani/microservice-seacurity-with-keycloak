package com.iraqsofit.speedoo.models;
import javax.persistence.*;

@Entity
@Table(name = "educational")
public class Educational{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,name = "id")
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "imageCover")
    private String imageCover;
    @Column(name = "uriVideo")
    private String uriVideo;

    public Educational(String title, String description, String imageCover, String uriVideo) {
        this.title = title;
        this.description = description;
        this.imageCover = imageCover;
        this.uriVideo = uriVideo;
    }

    public Educational() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    public String getUriVideo() {
        return uriVideo;
    }

    public void setUriVideo(String uriVideo) {
        this.uriVideo = uriVideo;
    }
}
