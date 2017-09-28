package com.example.android.fakeneaeasemusic.model;

import com.example.android.fakeneaeasemusic.model.Song;

import java.util.ArrayList;

/**
 * Created by lenovo on 9/21/2017.
 */

public class Album {
    private String playedNum;
    private String author;
    private String title;
    private ArrayList<Song> arrayList = new ArrayList<Song>();

    public Album() {
    }

    public Album(String playedNum, String author,String title, ArrayList<Song> arrayList) {
        this.playedNum = playedNum;
        this.author = author;
        this.title = title;
        this.arrayList = arrayList;
    }

    public String getPlayedNum() {
        return playedNum;
    }

    public void setPlayedNum(String playedNum) {
        this.playedNum = playedNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<Song> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Song> arrayList) {
        this.arrayList = arrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
