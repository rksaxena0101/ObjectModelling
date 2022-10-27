package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.PlayList;
//import com.crio.jukebox.entities.PlayListStatus;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.services.ISongService;

public class PlaySongCommand implements ICommand{

    private ISongService songService;
    private Songs songs;
    private Integer autoIncrement;
    private Integer songSize;

    public PlaySongCommand(ISongService songService) {
        this.songService = songService;
    }

    @Override
    public void execute(List<String> tokens) {
        PlayList playList = songService.getPlayListFromSong(Integer.parseInt(tokens.get(1)), tokens.get(2));

        if(tokens.get(2).equals("NEXT")) {
            System.out.println("Current Song Playing");
            this.autoIncrement += 1;

            if(autoIncrement > songSize - 1) {
                this.autoIncrement = 0;
            } 
            List<String> songIds = playList.getAllSong();
            this.songs = songService.getSong(Integer.parseInt(songIds.get(this.autoIncrement)));
            System.out.println("Song - " + songs.getSongs());
            System.out.println("Album - " + songs.getAlbum());

            String allArtists = "" ;
            //Artists - Ed Sheeran,Cardi.B,Camilla Cabello
            List<String> featuredArtist = songs.getfeaturedArtist();
            for(int i=0; i<featuredArtist.size()-1; i++) {
                allArtists += featuredArtist.get(i) + ",";
            }
            allArtists += featuredArtist.get(featuredArtist.size()-1);
            System.out.println("Artists - " + allArtists);

        } else if(tokens.get(2).equals("BACK")) {
            System.out.println("Current Song Playing");
            this.autoIncrement -= 1;

            if(autoIncrement < 0) {
                this.autoIncrement = this.songSize - 1;
            } 
            List<String> songIds = playList.getAllSong();
            this.songs = songService.getSong(Integer.parseInt(songIds.get(this.autoIncrement)));
            System.out.println("Song - " + songs.getSongs());
            System.out.println("Album - " + songs.getAlbum());

            String allArtists = "" ;
            //Artists - Ed Sheeran,Cardi.B,Camilla Cabello
            List<String> featuredArtist = songs.getfeaturedArtist();
            for(int i=0; i<featuredArtist.size()-1; i++) {
                allArtists += featuredArtist.get(i) + ",";
            }
            allArtists += featuredArtist.get(featuredArtist.size()-1);
            System.out.println("Artists - " + allArtists);
        } else {
            // if(playList.getPlayListStatus() == PlayListStatus.SONG_RUNNING) {

            // }
            
            List<String> songIds = playList.getAllSong();
            // for(String songId: songIds) {
            //     if(Integer.parseInt(songId) == Integer.parseInt(tokens.get(2))) {
            //         this.songs = songService.getSong(Integer.parseInt(tokens.get(2)));
            //     }
            // }
            this.autoIncrement = songIds.indexOf(tokens.get(2));//2
            this.songSize = songIds.size();//4

            if(songIds.contains(tokens.get(2))) {
                this.songs = songService.getSong(Integer.parseInt(tokens.get(2)));
                System.out.println("Current Song Playing");
                System.out.println("Song - " + songs.getSongs());
                System.out.println("Album - " + songs.getAlbum());

                String allArtists = "" ;
                //Artists - Ed Sheeran,Cardi.B,Camilla Cabello
                List<String> featuredArtist = songs.getfeaturedArtist();
                for(int i=0; i<featuredArtist.size()-1; i++) {
                    allArtists += featuredArtist.get(i) + ",";
                }
                allArtists += featuredArtist.get(featuredArtist.size()-1);
                System.out.println("Artists - " + allArtists);
            } else {
                System.out.println("Given song id is not a part of the active playlist");
            }
        }
    }

}
