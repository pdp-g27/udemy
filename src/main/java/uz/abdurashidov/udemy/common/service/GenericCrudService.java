package uz.abdurashidov.udemy.common.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import uz.abdurashidov.udemy.common.repository.GenericSpecificationRepository;
import uz.abdurashidov.udemy.common.rsql.SpecificationBuilder;

public abstract class GenericCrudService<ENTITY, ID, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO>
{
    public RESPONSE_DTO create( CREATE_DTO createDto )
    {
        ENTITY entity = getMapper().toEntity( createDto );
        ENTITY saved = getRepository().save( entity );
        return getMapper().toResponseDto( saved );
    }

    protected abstract GenericDtoMapper<ENTITY, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO> getMapper();

    protected abstract GenericSpecificationRepository<ENTITY, ID> getRepository();

    public Page<RESPONSE_DTO> getAll( Pageable pageable, String predicate )
    {
        Specification<ENTITY> specification = SpecificationBuilder.build( predicate );
        if( specification == null )
        {
            return getRepository().findAll( pageable )
                                  .map( entity -> getMapper().toResponseDto( entity ) );
        }
        return getRepository().findAll( specification, pageable )
                              .map( entity -> getMapper().toResponseDto( entity ) );
    }

    public RESPONSE_DTO getById( ID id )
    {
        ENTITY entity = getRepository()
            .findById( id )
            .orElseThrow( () -> throwException( id ) );
        return getMapper().toResponseDto( entity );
    }

    // todo make message generic
    public RuntimeException throwException( ID id )
    {
        Class<ENTITY> entityClass = getEntityClass();
        String message = "%s with id=%s not found".formatted( entityClass.getSimpleName(), id.toString() );
        return new EntityNotFoundException( message );
    }

    protected abstract Class<ENTITY> getEntityClass();

    public RESPONSE_DTO update( ID id, UPDATE_DTO updateDto )
    {
        ENTITY entity = getRepository()
            .findById( id )
            .orElseThrow( () -> throwException( id ) );
        getMapper().update( updateDto, entity );
        ENTITY saved = getRepository().save( entity );
        return getMapper().toResponseDto( saved );
    }

    public void delete( ID id )
    {
        getRepository().deleteById( id );
    }
}
