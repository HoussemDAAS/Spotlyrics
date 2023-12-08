package model;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private long id;
    private String title;
    private String titleShort;
    private String md5Image;
    List <Artist> artist= new ArrayList<>();
   List <Album> album=new ArrayList<>();

    // Constructor
    public Music(long id, String title, String titleShort, String md5Image,
                 List <Artist>  artist, List <Album> album) {
        this.id = id;
        this.title = title;
        this.titleShort = titleShort;
        this.md5Image = md5Image;
        this.artist = artist;
        this.album = album;
    }

    // Getters and Setters (omitted for brevity)

    // Getters and Setters for id, title, titleShort, md5Image, artist, and album
    // ...

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

    public String getTitleShort() {
        return titleShort;
    }

    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    public String getMd5Image() {
        return md5Image;
    }

    public void setMd5Image(String md5Image) {
        this.md5Image = md5Image;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;}


    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }
}
