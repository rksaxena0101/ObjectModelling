package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayListService;

public class DeletePlaylistCommand implements ICommand{

    private IPlayListService uPlayListService;

    public DeletePlaylistCommand(IPlayListService playlistService) {
        this.uPlayListService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        uPlayListService.deletePlayList(Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)));
        System.out.println("Delete Successful");
    }

}
