package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.PlayList;

public interface IPlayListService {
    public PlayList createPlayList(Integer userId, String playListName, List<String> songs);
    public void deletePlayList(Integer userId, Integer playListId);
    public PlayList getPlayList(Integer playlistId);
    
}
