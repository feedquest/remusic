package com.wm.remusic.json;

/**
 * Created by wm on 2016/8/3.
 */
public class RadioInfo {


    /**
     * song_id : 13015233
     * song_name : 我很好（刘若英）
     * song_duration : 273
     * songpic : {}
     */

    private String song_id;
    private String song_name;
    private String title;
    private String album_id;
    private String album_name;
    private String artist_name;
    private SongpicBean songpic;

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public SongpicBean getSongpic() {
        return songpic;
    }

    public void setSongpic(SongpicBean songpic) {
        this.songpic = songpic;
    }

    public static class SongpicBean {
    }
}
