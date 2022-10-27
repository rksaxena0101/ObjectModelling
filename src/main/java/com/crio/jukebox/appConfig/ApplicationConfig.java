package com.crio.jukebox.appConfig;

import com.crio.jukebox.services.IPlayListService;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.PlaylistService;
import com.crio.jukebox.services.SongService;
import com.crio.jukebox.services.UserService;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreatePlaylistCommand;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.DeletePlaylistCommand;
import com.crio.jukebox.commands.LoadDataCommand;
import com.crio.jukebox.commands.ModifyPlaylistCommand;
import com.crio.jukebox.commands.PlayPlaylistCommand;
import com.crio.jukebox.commands.PlaySongCommand;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.repositories.PlayListRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;

public class ApplicationConfig {
    private final IUserRepository userRepository = new UserRepository();
    private final IPlayListRepository playlistRepository = new PlayListRepository();
    private final ISongRepository songRepository = new SongRepository();

    private final ISongService songService = new SongService(songRepository, playlistRepository);
    private final IUserService userService = new UserService(userRepository, playlistRepository);
    private final IPlayListService playlistService = new PlaylistService(playlistRepository, songRepository, userRepository, userService);
    
    private final LoadDataCommand loadDataCommand = new LoadDataCommand(songService);
    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
    private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
    private final PlayPlaylistCommand playPlaylistCommand = new PlayPlaylistCommand(playlistService, songService);
    private final ModifyPlaylistCommand modifyPlaylistCommand = new ModifyPlaylistCommand(playlistService);
    private final PlaySongCommand playSongCommand = new PlaySongCommand(songService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("LOAD-DATA", loadDataCommand);
        commandInvoker.register("CREATE-USER", createUserCommand);
        commandInvoker.register("CREATE-PLAYLIST", createPlaylistCommand);
        commandInvoker.register("DELETE-PLAYLIST", deletePlaylistCommand);
        commandInvoker.register("PLAY-PLAYLIST", playPlaylistCommand);
        commandInvoker.register("MODIFY-PLAYLIST", modifyPlaylistCommand);
        commandInvoker.register("PLAY-SONG", playSongCommand);
        return commandInvoker;
    }
}
