package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.Exceptions.PlayListNotFoundException;
import com.crio.jukebox.Exceptions.UserNotFoundException;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;

public class PlaylistService implements IPlayListService {
    private IPlayListRepository playListRepository;
    private IUserRepository userRepository;
    private ISongRepository songRepository;
    private IUserService userService;

    public PlaylistService(IPlayListRepository playlistRepository, ISongRepository songRepository,
        IUserRepository userRepository, IUserService userService) {
            this.playListRepository = playlistRepository;
            this.userRepository = userRepository;
            this.songRepository = songRepository;
            this.userRepository = userRepository;
        }

        @Override
        public PlayList createPlayList(Integer userId, String playListName, List<String> songs) {
            final User user = userRepository.findById(userId).orElseThrow(
                    () -> new UserNotFoundException("User not found with name: " + playListName));
            PlayList playList = playListRepository.save(new PlayList(playListName, user, songs));
            user.addPlayList(playList);
            return playList;
        }

        @Override
        public void deletePlayList(Integer userId, Integer playListId) {
            final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot Create User. User for given id: " + userId + " not found!"));
            boolean ifPlayListExist = user.checkIfPlayListExist(new PlayList(playListId, user));
            if(ifPlayListExist) {
                playListRepository.deleteById(playListId);
            } else {
                throw new PlayListNotFoundException("Playlist not exist!");
            }   
        }

    @Override
    public PlayList getPlayList(Integer playlistId)  {
        return playListRepository.findById(playlistId).orElseThrow(() -> new PlayListNotFoundException("Playlist not exists"));
    }
}
