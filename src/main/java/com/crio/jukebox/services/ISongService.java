package com.crio.jukebox.services;

import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Songs;

public interface ISongService {
    public void loadPoolOfSongs(String fileName);
    public Songs playPlayList(Integer userId, Integer playListId);
    public PlayList getPlayListFromSong(Integer userId, String songId);
    public Songs getSong(Integer songId);
}
