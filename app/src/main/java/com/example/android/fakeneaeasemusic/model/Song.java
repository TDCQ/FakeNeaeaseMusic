package com.example.android.fakeneaeasemusic.model;

/**
 * Created by lenovo on 9/21/2017.
 */

public class Song {
    private String name;
    private  String singer;
    private String album;
    private String sound_quality;

    public Song() {
    }

    public Song(String name, String singer, String album, String sound_quality) {
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.sound_quality = sound_quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSound_quality() {
        return sound_quality;
    }

    public void setSound_quality(String sound_quality) {
        this.sound_quality = sound_quality;
    }
}