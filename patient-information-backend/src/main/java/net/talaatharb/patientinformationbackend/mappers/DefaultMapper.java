package net.talaatharb.patientinformationbackend.mappers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public interface DefaultMapper<E, D> {

	/**
	 * Convert a DTO to an entity
	 * 
	 * @param dto the DTO to be converted
	 * @return The entity resulting from converting the given DTO
	 */
	public abstract E fromDTOToEntity(D dto);

	/**
	 * Convert an entity to a DTO
	 * 
	 * @param entity the entity to be converted
	 * @return the DTO resulting from converting the given entity
	 */
	public abstract D fromEntityToDTO(E entity);

	/**
	 * Convert a list of entities to a list of DTOs
	 * 
	 * @param entityList the list of entities to convert
	 * @return the resulting DTO list from converting the entity list
	 */
	public abstract List<D> fromEntityToDTO(List<E> entityList);

	/**
	 * Convert a page of entities to a page of DTOs
	 * 
	 * @param entityPage the page of entities to convert
	 * @return the resulting DTO page from converting the entity page
	 */
	public default Page<D> fromEntityToDTO(Page<E> entityPage) {
		List<D> dtos = this.fromEntityToDTO(entityPage.getContent());
		return new PageImpl<>(dtos, entityPage.getPageable(), entityPage.getTotalElements());
	}
}
