package ru.kingsbot.repository;

public interface Repository<E, ID> {

    public void save(E entity);

    public E get(ID id);

    public void update(E entity);

    public E load(ID id);

    public void delete(ID id);

}
