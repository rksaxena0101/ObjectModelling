package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.services.IPlayListService;
import com.crio.jukebox.services.ISongService;

public class PlayPlaylistCommand implements ICommand {
    private ISongService uSongService;

    public PlayPlaylistCommand(IPlayListService playlistService, ISongService songService) {
        this.uSongService = songService;
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println("Current Song Playing");

        //Taking input userId and playListId from tokens.
       Songs song = uSongService.playPlayList(Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)));
        System.out.println("Song - "+ song.getSongs());
        System.out.println("Album - "+ song.getAlbum());
        String allFeaturedArtist = "";
        List<String> featuredArtist = song.getfeaturedArtist();
        for(int i = 0; i < featuredArtist.size() - 1; i++) allFeaturedArtist += featuredArtist.get(i) + ",";
        allFeaturedArtist += featuredArtist.get(featuredArtist.size() - 1);
        System.out.println("Artists - "+ allFeaturedArtist);
    }

}
