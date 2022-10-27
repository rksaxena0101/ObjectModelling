package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.entities.Songs;

public class SongRepository implements ISongRepository{
    private Map<Integer,Songs> uSongs = new HashMap<>();    
    private Integer autoIncrement = 0;

    @Override
    public Songs save(Songs entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Songs songs = new Songs(entity.getSongs(), entity.getGenreSong(), entity.getAlbum(), entity.getfeaturedArtist());
            uSongs.put(autoIncrement, songs);
            return songs;
        }
        uSongs.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<Songs> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Songs> findById(Integer id) {
        return Optional.ofNullable(uSongs.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Songs entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        uSongs.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

}
