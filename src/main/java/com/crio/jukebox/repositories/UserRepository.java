package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.User;

public class UserRepository implements IUserRepository{

    private final Map<Integer,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<Integer,User>();
    }

    public UserRepository(Map<Integer, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            User u = new User(autoIncrement,entity.getName());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<User> findAll() {
        return userMap.entrySet().stream().map(user -> user.getValue()).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> users = userMap.entrySet().stream().map(val -> val.getValue())
            .filter(userName -> userName.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        Optional<User> listOptional = users.stream().findAny();

        return listOptional;
    }
    
}
