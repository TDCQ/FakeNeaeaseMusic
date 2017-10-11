package com.example.android.fakeneaeasemusic.resource;

import android.content.Context;
import android.util.Log;

import com.example.android.fakeneaeasemusic.R;
import com.example.android.fakeneaeasemusic.model.Album;
import com.example.android.fakeneaeasemusic.model.Song;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by lenovo on 9/28/2017.
 */

public class ResourceAlbum {
    private static ArrayList<Album> albumArrayList;

    private ResourceAlbum(Context context) {
        this.albumArrayList = getArrayListAlbums(context);
        Log.v("this.albumArrayList=", "" + this.albumArrayList.size());
    }

    public static ArrayList<Album> getArrayListAlbums(Context context) {
        try {
            if (ResourceAlbum.albumArrayList == null || ResourceAlbum.albumArrayList.size() == 0) {
                synchronized (ResourceAlbum.class) {
                    // The InputStream opens the resourceId and sends it to the buffer
                    InputStream inputStream = context.getResources().openRawResource(R.raw.album);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line).append('\n');
                    }
                    line = stringBuilder.toString();
                    JSONObject jsonObject = new JSONObject(line);

                    // 解析json对象，重组Albums资源。 这里会有多张专辑，每张专辑又有多首歌
                    JSONArray albumsJSONArray = jsonObject.getJSONArray(context.getString(R.string.album_json_key));
                    ArrayList<Album> arrayListAlbum = new ArrayList<Album>();
                    //  外层循环遍历专辑
                    for (int i = 0; i < albumsJSONArray.length(); i++) {
                        Album album = new Album();
                        JSONObject albumJSONObject = albumsJSONArray.getJSONObject(i);
                        JSONArray songsJSONArray = albumJSONObject.getJSONArray(context.getString(R.string.songs_json_key));
                        ArrayList<Song> arrayListSong = new ArrayList<>();
                        // 内层循环遍历一张专辑里的每首歌
                        for (int j = 0; j < songsJSONArray.length(); j++) {
                            Song song = new Song();
                            JSONObject songJSONObject = songsJSONArray.getJSONObject(j);
                            song.setmAlbum(songJSONObject.getString(context.getString(R.string.album_name_json_key)));
                            song.setmName(songJSONObject.getString(context.getString(R.string.song_title_json_key)));
                            song.setmSinger(songJSONObject.getString(context.getString(R.string.singer_json_key)));
                            song.setmSoundQuality(songJSONObject.getString(context.getString(R.string.song_quality_json_key)));
                            arrayListSong.add(song);
                        }
                        album.setTitle(albumJSONObject.getString(context.getString(R.string.album_title_json_key)));
                        album.setAuthor(albumJSONObject.getString(context.getString(R.string.album_creator_json_key)));
                        album.setPlayedNum(albumJSONObject.getString(context.getString(R.string.album_played_num_json_key)));
                        album.setArrayList(arrayListSong);
                        arrayListAlbum.add(album);
                    }
                    return arrayListAlbum;
                }
            } else {
                return ResourceAlbum.albumArrayList;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
