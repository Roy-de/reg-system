package org.learn.regsystem.service;


import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractService<T, Y, ID> implements Services<T, Y> {

    //Create the Json Mapper to map out dtos to entities and back
    protected final JsonMapper jsonMapper = new JsonMapper();
    protected final JpaRepository<T, ID> repository;

    protected AbstractService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    private T mapDtoToEntity(Class<T> entityClass, Y dtoClass){
        return jsonMapper.convertValue(dtoClass, entityClass);
    }

    @Override
    public T create(Y y) throws Exception  {
        T entity = mapDtoToEntity(getEntityClass(), y);
        return repository.save(entity);
    }

    @Override
    public T update(Y y) throws Exception  {

        T entity = mapDtoToEntity(getEntityClass(), y);
        return repository.save(entity);
    }

    @Override
    public void delete(Y y) throws Exception  {
        T entity = mapDtoToEntity(getEntityClass(), y);
        repository.delete(entity);
    }

    @Override
    public List<T> findAll() throws Exception  {
        return repository.findAll();
    }

    @Override
    public T findById(UUID id) throws Exception  {
        Optional<T> entity = repository.findById((ID) id);
        return entity.orElse(null);
    }

    @Override
    public T login(Y y) throws Exception {
        return null;
    }

    protected abstract Class<T> getEntityClass();
}
