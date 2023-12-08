package model;

import java.util.List;

public class Artist {
    private int id;
    private String name;
    private String picture;
    private String picture_medium;
    private String picture_big;
    private int nb_album;
    private List<Track> tracklist;
    private String type;

    // Constructors, getters, and setters

    public Artist() {
        // Default constructor
    }

    public Artist(int id, String name, String picture, String picture_medium, String picture_big, int nb_album,
                  List<Track> tracklist, String type) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.picture_medium = picture_medium;
        this.picture_big = picture_big;
        this.nb_album = nb_album;
        this.tracklist = tracklist;
        this.type = type;
    }

    // Getter and setter methods go here

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }

    public int getNb_album() {
        return nb_album;
    }

    public void setNb_album(int nb_album) {
        this.nb_album = nb_album;
    }

    public List<Track> getTracklist() {
        return tracklist;
    }

    public void setTracklist(List<Track> tracklist) {
        this.tracklist = tracklist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
