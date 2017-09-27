package com.example.android.fakeneaeasemusic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.start;

/**
 * Created by lenovo on 9/26/2017.
 */

public class AdapterForAlbum extends RecyclerView.Adapter<AdapterForAlbum.ViewHolder>  {
    private ArrayList<Album> albumArrayList;

    // 设置内部类来绑定RecyclerView 中的视图与ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_album_played_num, tv_album_title;
        ImageView iv_album_cover;
        RelativeLayout rl_album;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_album_played_num = itemView.findViewById(R.id.album_played_num);
            tv_album_title = itemView.findViewById(R.id.album_title);
            iv_album_cover = itemView.findViewById(R.id.album_cover);
            rl_album = itemView.findViewById(R.id.album);
        }
    }

    // LayoutManager 调用此函数，创建新视图
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建视图
        View v = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.recyclerview_album, parent, false);
        // 返回视图holder
        return new ViewHolder(v);
    }

    // 替换视图中的内容
    @Override
    public void onBindViewHolder(AdapterForAlbum.ViewHolder holder, final int position) {
        Album album = albumArrayList.get(position);
        holder.tv_album_played_num.setText(album.getPlayedNum());
        holder.tv_album_title.setText(album.getTitle());
        Log.e("position", "position=" + position);
        switch (position) {
            case 0:
                holder.iv_album_cover.setImageResource(R.drawable.a0);
                break;
            case 1:
                holder.iv_album_cover.setImageResource(R.drawable.a1);
                break;
            case 2:
                holder.iv_album_cover.setImageResource(R.drawable.a2);
                break;
            case 3:
                holder.iv_album_cover.setImageResource(R.drawable.a3);
                break;
            case 4:
                holder.iv_album_cover.setImageResource(R.drawable.a4);
                break;
            case 5:
                holder.iv_album_cover.setImageResource(R.drawable.a5);
                break;
        }
        holder.rl_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent albumDetailIntent = new Intent(context, AlbumActivity.class);
                albumDetailIntent.putExtra("albumNo", position);
                context.startActivity(albumDetailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }


    public AdapterForAlbum(ArrayList<Album> albumArrayList) {
        this.albumArrayList = (ArrayList<Album>) albumArrayList.clone();
    }

}
