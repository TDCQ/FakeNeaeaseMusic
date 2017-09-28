package com.example.android.fakeneaeasemusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.fakeneaeasemusic.model.Album;
import com.example.android.fakeneaeasemusic.resource.ResourceAlbum;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAlbum;
    private GridLayoutManager gridLayoutManagerAlbum;
    private RecyclerView.Adapter adapterAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 查找视图
        recyclerViewAlbum = (RecyclerView) findViewById(R.id.recycler_view_album);
        // 创建布局管理器
        gridLayoutManagerAlbum = new GridLayoutManager(this, 3);
        // 为视图绑定布局管理器
        recyclerViewAlbum.setLayoutManager(gridLayoutManagerAlbum);
        // 创建适配器
        ArrayList<Album> ALBUM_ARRAY_LIST = new ResourceAlbum().getAlbumArrayList();
        adapterAlbum = new AdapterForAlbum(ALBUM_ARRAY_LIST);
        // 为视图绑定适配器
        recyclerViewAlbum.setAdapter(adapterAlbum);

        recyclerViewAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumIntent);
            }
        });


    }
}
