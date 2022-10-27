package com.crio.jukebox.services;

import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.BaseEntity;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.IUserRepository;
import java.util.HashMap;

public class UserService extends BaseEntity implements IUserService{
   private Map<Integer, String> userName = new HashMap<Integer, String>();
    private final IUserRepository userRepository;
    private final IPlayListRepository playListRepository;

    public UserService(IUserRepository userRepository, IPlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name) {
        User user = new User(1, name);
        return userRepository.save(user); 
    }

    @Override
    public String getUserById(Integer id) {
        String name  = userName.get(id);
        return name;
    }

    @Override
    public List<String> getListOfUsers() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
