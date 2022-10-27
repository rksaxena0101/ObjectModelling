package com.crio.jukebox.services;

import java.util.List;

public interface IUserService {
    public com.crio.jukebox.entities.User createUser(String name);
    public String getUserById(Integer id);
    public List<String> getListOfUsers();
}
