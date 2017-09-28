package com.example.android.fakeneaeasemusic.resource;

import com.example.android.fakeneaeasemusic.model.Album;
import com.example.android.fakeneaeasemusic.model.Song;

import java.util.ArrayList;

/**
 * Created by lenovo on 9/28/2017.
 */

public class ResourceAlbum {
    private ArrayList<Album> albumArrayList;

    public ResourceAlbum() {
        createListAlbum();
    }

    public ArrayList<Album> getAlbumArrayList() {
        return this.albumArrayList;
    }

    public void setAlbumArrayList(ArrayList<Album> albumArrayList) {
        this.albumArrayList = albumArrayList;
    }

    public void createListAlbum() {
        albumArrayList = new ArrayList<Album>();
        // 第一张专辑
        ArrayList<Song> arrayList = new ArrayList<Song>();
        arrayList.add(new Song("Wonderland", "卫兰/廿四味", "Wonderland", ""));
        arrayList.add(new Song("比你浪，比你棒", "Ty.", "比你浪，比你棒", "HQ"));
        arrayList.add(new Song("一口气全念对", "周杰伦", "哎呦，不错哦", "SQ"));
        Album album = new Album("2413万","柚子_ccc", "这波节奏很棒很强", arrayList);
        albumArrayList.add(album);
        // 第二张专辑
        ArrayList<Song> arrayList1 = new ArrayList<Song>();
        arrayList1.add(new Song("Battle Symphony", "Linkin Park", "One more night", "SQ"));
        arrayList1.add(new Song("Immortals(End Credit Version)", "Fall out Boy", "Immortals(End Credit Version)", "HQ"));
        arrayList1.add(new Song("I just want run", "周杰伦", "哎呦，不错哦", "SQ"));
        Album album1 = new Album("5994万","零下Young", "【欧美男团】秒杀耳朵系列", arrayList1);
        albumArrayList.add(album1);
        // 第三张专辑
        ArrayList<Song> arrayList2 = new ArrayList<Song>();
        arrayList2.add(new Song("The More", "Hans Zimmer", "Dunkirk: Original Motion Picture", "SQ"));
        arrayList2.add(new Song("Helmet to Helmet", "Brand X Music", "Oblivion Rise", ""));
        arrayList2.add(new Song("Dota", "Basshunter", "Now You're gone", "SQ"));
        Album album2 = new Album("4602万","皇太极", "【酷到没朋友】BGM燃点爆炸", arrayList2);
        albumArrayList.add(album2);
        // 第四张专辑
        ArrayList<Song> arrayList3 = new ArrayList<Song>();
        arrayList3.add(new Song("寂静之声", "群星", "吟唱天堂", ""));
        arrayList3.add(new Song("天空之城", "K.Williams", "金色钢琴", "HQ"));
        arrayList3.add(new Song("爱的纪念", "Richard Clayderman", "Richard Clayderman", "SQ"));
        Album album3 = new Album("3241万","橘子树风车", "世界上最好听的纯音乐（经典不朽）", arrayList3);
        albumArrayList.add(album3);
        // 第五张专辑
        ArrayList<Song> arrayList4 = new ArrayList<Song>();
        arrayList4.add(new Song("Gently Dreaming", "", "", ""));
        arrayList4.add(new Song("The Canon Stirs", ".", "", "HQ"));
        arrayList4.add(new Song("Music life in forest", "", "", "SQ"));
        Album album4 = new Album("1934万","DJ雪梨", "安静看书的背景音乐", arrayList4);
        albumArrayList.add(album4);
        // 第六张专辑
        ArrayList<Song> arrayList5 = new ArrayList<Song>();
        arrayList5.add(new Song("Wonderland", "卫兰/廿四味", "Wonderland", ""));
        arrayList5.add(new Song("比你浪，比你棒", "Ty.", "比你浪，比你棒", "HQ"));
        arrayList5.add(new Song("一口气全念对", "周杰伦", "哎呦，不错哦", "SQ"));
        Album album5= new Album("2802万","柚子_ccc", "这波节奏很棒很强", arrayList5);
        albumArrayList.add(album5);

    }

}
