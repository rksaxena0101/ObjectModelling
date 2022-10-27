package com.crio.jukebox.entities;

import java.util.List;

public class Songs extends BaseEntity{
    private final String songsName;
    private final String albumName;
    private String genreSong;
    private List<String> featuredArtist;

    // public Songs(Integer songId, String songName, String albumName) {
    //     this.id = songId;
    //     this.songsName = songName;
    //     this.albumName = albumName;
    // }

    public Songs(Songs uSongs) {
        this(uSongs.songsName, uSongs.genreSong, uSongs.albumName, uSongs.featuredArtist);
    }

    public Songs(String songsName2, String genreSong2, String albumName2, List<String> featuredArtist2) {
        this.songsName = songsName2;
        this.genreSong = genreSong2;
        this.albumName = albumName2;
        this.featuredArtist = featuredArtist2;
    }

    public String getSongs() {
        return songsName;
    }

    public String getAlbum() {
        return albumName;
    }

    public String getGenreSong() {
        return genreSong;
    }

    public List<String> getfeaturedArtist() {
        return featuredArtist;
    }
    
}
