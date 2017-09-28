package com.example.android.fakeneaeasemusic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.fakeneaeasemusic.model.Album;
import com.example.android.fakeneaeasemusic.model.Song;

/**
 * Created by lenovo on 9/21/2017.
 */

public class AdapterForAlbumSong extends RecyclerView.Adapter<AdapterForAlbumSong.ViewHolder> {
    private Album mDataset;


    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterForAlbumSong(Album album) {
        mDataset = album;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_album_song, parent, false);
        // set the view's size, margins, padding and layout parameters
        // ...
        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Song song = mDataset.getArrayList().get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.song_order.setText("" + (position + 1));
        holder.album_title.setText(song.getAlbum());
        holder.song_name.setText(song.getName());
        holder.singer.setText(song.getSinger());
        holder.sound_quality.setText(song.getSound_quality());
        holder.lv_song_in_album_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent playSongIntent = new Intent(context, SongActivity.class);
                playSongIntent.putExtra("song_name", song.getName());
                playSongIntent.putExtra("singer", song.getSinger());
                context.startActivity(playSongIntent);

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.getArrayList().size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView song_order, song_name, sound_quality, singer, album_title;
        LinearLayout lv_song_in_album_list;

        public ViewHolder(LinearLayout v) {
            super(v);
            song_order = v.findViewById(R.id.song_order_of_album);
            song_name = v.findViewById(R.id.song_name);
            sound_quality = v.findViewById(R.id.sound_quality);
            singer = v.findViewById(R.id.singer);
            album_title = v.findViewById(R.id.album_title);
            lv_song_in_album_list = v.findViewById(R.id.song_in_album_list);
        }
    }
}
