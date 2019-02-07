package ru.kingsbot.repository;

public interface Repository<Entity, Key> {

    public void save(Entity entity);

    public Entity get(Key id);

    public void update(Entity entity);

    public Entity load(Key id);

    public void delete(Key id);

}
