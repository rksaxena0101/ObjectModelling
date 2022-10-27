package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.services.IPlayListService;

public class CreatePlaylistCommand implements ICommand {

    private IPlayListService uPlaylistService;

    public CreatePlaylistCommand(IPlayListService mPlaylistService) {
        this.uPlaylistService = mPlaylistService;
    }

    @Override
    public void execute(List<String> tokens) {
        List<String> playlistSongs = new ArrayList<>();
        for(int i=3; i<tokens.size(); i++) {
            playlistSongs.add(tokens.get(i));
        }
        PlayList mPlaylist = uPlaylistService.createPlayList(Integer.parseInt(tokens.get(1)), tokens.get(2), playlistSongs);
        System.out.println("Playlist ID - "+ mPlaylist.getId()); //If Playlist already exist
        
    }
    
}



















// package com.crio.jukebox.commands;

// import java.util.ArrayList;
// import java.util.List;
// import com.crio.jukebox.entities.PlayList;
// import com.crio.jukebox.services.IPlayListService;

// public class CreatePlaylistCommand implements ICommand{
//     private IPlayListService playListService;

//     public CreatePlaylistCommand(IPlayListService playlistService) {
//         this.playListService = playListService;
//     }

//     @Override
//     public void execute(List<String> tokens) {
//         List<String> songsId = new ArrayList<>();
//         for(int i = 3; i < tokens.size(); i++) {
//             songsId.add(tokens.get(i));
//         }
//         PlayList playList = playListService.createPlayList(Integer.parseInt(tokens.get(1)),tokens.get(2), songsId);
//         Integer playListId = playList.getId();
//         System.out.println("Playlist ID - " + playListId++);
//     }

// }
