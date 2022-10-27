package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity{
    private final String name;
    private List<PlayList> userPlayList = new ArrayList<>();
    private List<Songs> userSongs = new ArrayList<>();

    public User(User user) {
        this(user.id, user.name, user.userPlayList, user.userSongs);
    }

    public User(Integer id, String name, List<PlayList> userPlayList2, List<Songs> userSongs) {
        this(id, name);
        this.userPlayList = userPlayList2;
        this.userSongs = userSongs;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkIfPlayListExist(PlayList playList) {
        for(PlayList i: userPlayList) {
            if(i.getId() == playList.getId()) return true;
        }
        return false;
    }

    public void addPlayList(PlayList playList) {
       userPlayList.add(playList);
    }

    public void deleteSongFromPlayList(Songs songs) {
        userPlayList.removeIf(s -> s.getId() == songs.getId());
    }

    public void deletePlayList(int userId, int playListId) {
        
    }

    
}
