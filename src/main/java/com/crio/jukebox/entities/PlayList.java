package com.crio.jukebox.entities;

import java.util.List;

public class PlayList extends BaseEntity{

    private User user;
    private String name;
    private List<String> uSongId;
    private PlayListStatus playListStatus;

    public PlayListStatus getPlayListStatus() {
        return playListStatus;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public List<String> getAllSong() {
        return uSongId;
    }

    public PlayList(String name, Integer id) {
        this.id = id;
        this.name = name;
    }

    public PlayList(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public PlayList(Integer id, String name, User user, List<String> songId) {
        this(name, user);
        this.uSongId = songId;
        this.id = id;
    }

    public PlayList(PlayList playlist) {
        this(playlist.id, playlist.name, playlist.user, playlist.uSongId);
    }

    public PlayList(Integer playListId, User user) {
        this.id = playListId;
        this.user = user;
    }

    public PlayList(String playListName, User user2, List<String> songs) {
        this.name = playListName;
        this.user = user2;
        this.uSongId = songs;
    }

    public PlayList(Integer id, String name2, User user2, List<String> allSong,
            PlayListStatus songRunning) {
                this(id, name2, user2, allSong);
                this.playListStatus = songRunning;
            }

    // public boolean checkIfSongIdExist(Integer songId) {
    //     for(PlayList i: uSongId){
    //         if(songId == i.) return true;
    //     }
    //     return false;
    // }
    
}
