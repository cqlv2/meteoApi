package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.dto.SuperDto;
import dev.entity.SuperEntity;
import dev.exceptions.repositoryException;
import dev.utils.transformer.SuperTransformer;

/**
 * extended to all services. adds the basic methods of CRUD
 * 
 * @author cql-v2
 * @version 1.0
 *
 * @param <T>       class of the entity for which the service works
 * @param <R>       entity's depository for which the service operates * @param
 * @param <DtoRep>  data transfer object in which to parse responses from the
 *                  persistence layer
 * @param <DtoQuer> data transfer object to transform into an entity for
 *                  persistence layer requests
 * 
 */

public abstract class SuperService<T extends SuperEntity, R extends JpaRepository<T, Long>, DtoRep , DtoQuer> {

	@Autowired
	protected R repository;

	/**
	 * find all the entries in the database corresponding to the entity
	 * 
	 * @return a list of 0 to n value formatted in DTO
	 */
	public List<DtoRep> getAll() {
		List<DtoRep> list = new ArrayList<>();
		for (T entity : repository.findAll())
			list.add((DtoRep) SuperTransformer.entityToDtoResponse(entity));
		return list;
	}

	/**
	 * find an entry in the database corresponding to an id
	 * 
	 * @param id id to search
	 * @return a value corresponding to the id formatted in DTO
	 * @throws repositoryException exception thrown if id is not found
	 */
	public DtoRep getById(Long id) throws repositoryException {
		Optional<T> opt = repository.findById(id);
		if (opt.isPresent())
			return (DtoRep) SuperTransformer.entityToDtoResponse(opt.get());
		else
			throw new repositoryException("id non trouvée");
	}

	/**
	 * created or modified an entry in the database
	 * @param dtoQuery an instance of a dto Query Object
	 * @return a dto of the created/modified entity
	 */
	public Object addUpdate(Object dtoQuery) {
		return (DtoRep) SuperTransformer
				.entityToDtoResponse(repository.save((T) SuperTransformer.dtoToEntity(dtoQuery)));
	}
	
	/**
	 * removes an entry from the database from an id or throws an exception if the id does not exist
	 * @param id id to remove
	 * @throws repositoryException throws if the id does not exist
	 */
	public void delete(Long id) throws repositoryException {
		Optional<T> opt=repository.findById(id);
		if(opt.isPresent()) repository.delete(opt.get());
		else throw new repositoryException("id introuvable");
		
	}


}
