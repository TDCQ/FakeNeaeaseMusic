package com.example.android.fakeneaeasemusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.fakeneaeasemusic.model.Album;
import com.example.android.fakeneaeasemusic.resource.ResourceAlbum;

import java.util.ArrayList;

import static android.R.attr.data;

public class AlbumActivity extends AppCompatActivity {
    private final int SONG_REQUEST_CODE = 0;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        // custom
        readyForRecyclerView();

    }

    private void readyForRecyclerView() {
        if (getIntent().getExtras() != null) {
            TextView mAlbumTitle = (TextView) findViewById(R.id.song_list_title);
            String title = getIntent().getExtras().getString("album_title");
            mAlbumTitle.setText(title);
        }

        // 查找视图
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 创建布局管理器
        mLayoutManager = new LinearLayoutManager(this);
        // 为视图设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 创建适配器
        ArrayList<Album> albumArrayList = ResourceAlbum.getArrayListAlbums(AlbumActivity.this);
        // todo 修改让其调用onActivityResult方法，而不是调用 onCreate 方法。
        int albumNo = 0;
        if (getIntent().getExtras() != null) {
            albumNo = getIntent().getExtras().getInt("albumNo");
        }
        mAdapter = new AdapterForAlbumSong(albumArrayList.get(albumNo));
        // 为视图设置适配器
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == SONG_REQUEST_CODE) {
            if (data.hasExtra("albumNo")) {
                readyForRecyclerView();
            }
        }
    }
}
