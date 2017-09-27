package com.example.android.fakeneaeasemusic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 9/21/2017.
 */

public class AdapterForAlbumSong extends RecyclerView.Adapter<AdapterForAlbumSong.ViewHolder>   {
    private Album mDataset;
    private Context mContext;
    private List<Song> albumList;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView song_name, sound_quality, singer, album_title;
        public ViewHolder(LinearLayout v) {
            super(v);
            song_name = v.findViewById(R.id.song_name);
            sound_quality = v.findViewById(R.id.sound_quality);
            singer = v.findViewById(R.id.singer);
            album_title = v.findViewById(R.id.album_title);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_song, parent, false);
        // set the view's size, margins, padding and layout parameters
        // ...
        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = mDataset.getArrayList().get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.album_title.setText(song.getAlbum());
        holder.song_name.setText(song.getName());
        holder.singer.setText(song.getSinger());
        holder.sound_quality.setText(song.getSound_quality());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.getArrayList().size();
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterForAlbumSong(Album album) {
        mDataset = album;
    }
}
