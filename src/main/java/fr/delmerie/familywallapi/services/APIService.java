package fr.delmerie.familywallapi.services;

import java.util.List;
import java.util.Optional;

public interface APIService<T> {
    public List<T> getAll();

    public Optional<T> getOneById(long id);

    public T save(T obj);

    public void delete(long id);
}
