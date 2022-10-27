package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.entities.PlayList;

public class PlayListRepository implements IPlayListRepository{
    private int autoIncrement = 0;
    private Map<Integer, PlayList> playMap = new HashMap<>();

    @Override
    public PlayList save(PlayList entity) { 
        if( entity.getId() == null ){
            autoIncrement++;
            PlayList playlist = new PlayList(autoIncrement, entity.getName(), entity.getUser(), entity.getAllSong());
            playMap.put(autoIncrement, playlist);
            return playlist;
        }
        playMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<PlayList> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<PlayList> findById(Integer id) { 
        return Optional.ofNullable(playMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(PlayList entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        playMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
}
