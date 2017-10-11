package com.example.android.fakeneaeasemusic.model;

/**
 * Created by lenovo on 9/21/2017.
 */

public class Song {
    private String mName;
    private String mSinger;
    private String mAlbum;
    private String mSoundQuality;

    public Song() {
    }

    public Song(String mName, String mSinger, String mAlbum, String mSoundQuality) {
        this.mName = mName;
        this.mSinger = mSinger;
        this.mAlbum = mAlbum;
        this.mSoundQuality = mSoundQuality;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSinger() {
        return mSinger;
    }

    public void setmSinger(String mSinger) {
        this.mSinger = mSinger;
    }

    public String getmAlbum() {
        return mAlbum;
    }

    public void setmAlbum(String mAlbum) {
        this.mAlbum = mAlbum;
    }

    public String getmSoundQuality() {
        return mSoundQuality;
    }

    public void setmSoundQuality(String mSoundQuality) {
        this.mSoundQuality = mSoundQuality;
    }
}