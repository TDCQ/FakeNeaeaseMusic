package com.example.android.fakeneaeasemusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        // 查找视图
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 创建布局管理器
        mLayoutManager = new LinearLayoutManager(this);
        // 为视图设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 创建适配器
        int albumNo = getIntent().getExtras().getInt("albumNo");
        ArrayList<Album> albumArrayList = new ResourceAlbum().getAlbumArrayList();
        mAdapter = new AdapterForAlbumSong(albumArrayList.get(albumNo));
        // 为视图设置适配器
        mRecyclerView.setAdapter(mAdapter);

    }
}
