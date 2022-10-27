package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.services.IPlayListService;

public class ModifyPlaylistCommand implements ICommand{

    private IPlayListService playListService;
    private PlayList playList;
    private List<String> allSongIds;

    public ModifyPlaylistCommand(IPlayListService uPlaylistService) {
        this.playListService = uPlaylistService;
    }
    public ModifyPlaylistCommand(IPlayListService uPlaylistService, PlayList uPlayList, List<String> allSongIds) {
        this.playListService = uPlaylistService;
        this.playList = uPlayList;
        this.allSongIds = allSongIds;
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println("Playlist ID - " + tokens.get(3));
        if(tokens.get(1).contains("ADD")) {
            getPlayListAndAllSongs(tokens);
            if(allSongIds.contains(tokens.get(4))) {
                
            } else {
                allSongIds.add(tokens.get(4));
            }
            createAndPrintPlayListAndSongIds(tokens, allSongIds);
        } else if(tokens.get(1).contains("DELETE")){
            getPlayListAndAllSongs(tokens);
            if(allSongIds.contains(tokens.get(4))) allSongIds.remove(tokens.get(4));  
            createAndPrintPlayListAndSongIds(tokens, allSongIds);
        }
    }

    public void getPlayListAndAllSongs(List<String> tokens) {
        this.playList = playListService.getPlayList(Integer.parseInt(tokens.get(3)));
        this.allSongIds = playList.getAllSong();
    }

    public void createAndPrintPlayListAndSongIds(List<String> tokens, List<String> allSongIds) {
        this.playList = playListService.createPlayList(Integer.parseInt(tokens.get(2)), this.playList.getName(), allSongIds);
        System.out.println("Playlist Name - "+ playList.getName());
        String allSongsIDs = "";
        for(int i=0; i < allSongIds.size()-1; i++) {
            allSongsIDs += allSongIds.get(i) + " ";
        }
        allSongsIDs += allSongIds.get(allSongIds.size()-1);
        System.out.println("Song IDs - "+ allSongsIDs);
    }
}
