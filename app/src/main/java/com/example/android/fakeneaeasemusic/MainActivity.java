package com.example.android.fakeneaeasemusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.fakeneaeasemusic.model.Album;
import com.example.android.fakeneaeasemusic.model.Song;
import com.example.android.fakeneaeasemusic.resource.ResourceAlbum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 查找视图
        RecyclerView recyclerViewAlbum = (RecyclerView) findViewById(R.id.recycler_view_album);
        // 创建布局管理器
        GridLayoutManager gridLayoutManagerAlbum = new GridLayoutManager(this, 3);
        // 为视图绑定布局管理器
        recyclerViewAlbum.setLayoutManager(gridLayoutManagerAlbum);
        // 创建适配器
        ArrayList<Album> arrayListAlbums = ResourceAlbum.getArrayListAlbums(MainActivity.this);
        ArrayList<Album> ALBUM_ARRAY_LIST = arrayListAlbums;
        RecyclerView.Adapter adapterAlbum = new AdapterForAlbum(ALBUM_ARRAY_LIST);
        // 为视图绑定适配器
        recyclerViewAlbum.setAdapter(adapterAlbum);
    }


}
