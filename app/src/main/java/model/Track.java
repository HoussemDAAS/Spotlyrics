package model;

import java.util.List;

public class Track {
    private int id;
    private String title;
    private String image;
    private Artist artist;
    private Album album;
    private String type;

    // Constructors, getters, and setters

    public Track() {
        // Default constructor
    }

    public Track(int id, String title, String image,Artist artist, Album album, String type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.artist = artist;
        this.album = album;
        this.type = type;
    }

    // Getter and setter methods go here

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
