package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.Exceptions.PlayListNotFoundException;
import com.crio.jukebox.Exceptions.SongNotFoundException;
import com.crio.jukebox.Exceptions.UserNotHavingPlaylistException;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.PlayListStatus;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.ISongRepository;

public class SongService implements ISongService{

    private ISongRepository songRepository;
    private List<String> allSongs;
    private List<String> playPlaylist = new ArrayList<>();
    private IPlayListRepository playListRepository;
    private PlayList playList;
    
    public SongService(ISongRepository songRepository, IPlayListRepository playListRepository) {
        this.songRepository = songRepository;
        this.playListRepository = playListRepository;
    }

    @Override
    public void loadPoolOfSongs(String file) {
         this.allSongs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                allSongs.add(line);
            }
            br.close();
        }catch (IOException e) {  
            e.printStackTrace();  
        } 

        for(String listOfSongs: allSongs) {
            playPlaylist = Arrays.asList(listOfSongs.split(","));
            songRepository.save(new Songs(playPlaylist.get(0), playPlaylist.get(1), playPlaylist.get(2), Arrays.asList(playPlaylist.get(playPlaylist.size()-1).split("#"))));
         } 
        
    }

    @Override
    public Songs playPlayList(Integer userId, Integer playListId) {
         this.playList = playListRepository.findById(playListId).orElseThrow(() -> new PlayListNotFoundException("Playlist not Found Exception!"));

        if(playList.getUser().getId() == userId) {
            //It will give 1st id from playList
            Integer songId = Integer.parseInt(playList.getAllSong().get(0));
            if(songId == playList.getId()) {
                playList = new PlayList(playList.getId(), playList.getName(), playList.getUser(), playList.getAllSong(), PlayListStatus.SONG_RUNNING);
            }
            return songRepository.findById(songId).orElseThrow(() -> new SongNotFoundException("Songs not Found Exception!"));
        } else {
            throw new UserNotHavingPlaylistException("Playlist doesn't exist with the User ID given.");
        }
    }

    @Override
    public PlayList getPlayListFromSong(Integer userId, String songId) {
        return this.playList;
    }

    @Override
    public Songs getSong(Integer songId) {
        return songRepository.findById(songId).orElseThrow(() -> new SongNotFoundException("Song not found!"));
    }
    
}
