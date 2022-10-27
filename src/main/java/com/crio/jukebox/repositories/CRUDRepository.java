package com.crio.jukebox.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T,ID> {
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(Integer id);
    boolean existsById(ID id);
    public void delete(T entity);
    public void deleteById(Integer id);
    public long count();
}
