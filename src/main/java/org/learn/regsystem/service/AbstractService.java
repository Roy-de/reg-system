package org.learn.regsystem.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Abstract base service class providing common CRUD operations for entities.
 * Uses a generic repository and JSON mapper for DTO-to-entity conversions.
 *
 * @param <T>  The entity type.
 * @param <Y>  The DTO type.
 * @param <ID> The primary key type of the entity.
 */
public abstract class AbstractService<T, Y, ID> implements Services<T, Y, ID> {

    /**
     * JSON mapper used for converting between DTOs and entities.
     */
    protected final JsonMapper jsonMapper = new JsonMapper();

    /**
     * Repository for database operations on the entity.
     */
    protected final JpaRepository<T, ID> repository;

    /**
     * Constructs an AbstractService with the specified repository.
     *
     * @param repository the JPA repository for the entity type.
     */
    protected AbstractService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    /**
     * Converts a DTO object to its corresponding entity type.
     *
     * @param entityClass the class of the entity.
     * @param dtoClass    the DTO object to be converted.
     * @return the mapped entity object.
     */
    private T mapDtoToEntity(Class<T> entityClass, Y dtoClass) {
        return jsonMapper.convertValue(dtoClass, entityClass);
    }

    /**
     * Creates a new entity from the provided DTO and saves it to the database.
     *
     * @param y the DTO object.
     * @return the saved entity.
     * @throws Exception if an error occurs during the save operation.
     */
    @Override
    public T create(Y y) throws Exception {
        T entity = mapDtoToEntity(getEntityClass(), y);
        return repository.save(entity);
    }

    /**
     * Updates an existing entity with the provided DTO data.
     *
     * @param y the DTO object.
     * @return the updated entity.
     * @throws Exception if an error occurs during the update operation.
     */
    @Override
    public T update(Y y) throws Exception {
        T entity = mapDtoToEntity(getEntityClass(), y);
        return repository.save(entity);
    }

    /**
     * Deletes an entity represented by the provided DTO from the database.
     *
     * @param y the DTO object.
     * @throws Exception if an error occurs during the delete operation.
     */
    @Override
    public void delete(Y y) throws Exception {
        T entity = mapDtoToEntity(getEntityClass(), y);
        repository.delete(entity);
    }

    /**
     * Retrieves all entities of the specified type from the database.
     *
     * @return a list of all entities.
     * @throws Exception if an error occurs during the retrieval.
     */
    @Override
    public List<T> findAll() throws Exception {
        return repository.findAll();
    }

    /**
     * Finds an entity by its ID.
     *
     * @param id the unique identifier of the entity.
     * @return the entity if found, or {@code null} if not found.
     */
    @Override
    public T findById(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.orElse(null);
    }

    /**
     * Placeholder for a login operation. Throws an UnsupportedOperationException by default.
     *
     * @param y the DTO object for login (e.g., credentials).
     * @return an entity if the login is successful.
     * @throws UnsupportedOperationException as login functionality is not supported in this class.
     */
    @Override
    public T login(Y y) throws Exception {
        throw new UnsupportedOperationException("Login operation not supported");
    }

    /**
     * Abstract method to be implemented by subclasses to specify the entity class type.
     *
     * @return the entity class.
     */
    protected abstract Class<T> getEntityClass();
}
