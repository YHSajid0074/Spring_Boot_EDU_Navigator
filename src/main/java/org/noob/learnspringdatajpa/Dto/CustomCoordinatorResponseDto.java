package org.noob.learnspringdatajpa.Dto;

/**
 * Projection for {@link org.noob.learnspringdatajpa.entities.Coordinator}
 */
public interface CustomCoordinatorResponseDto {
    Long getId();

    String getFullName();

    String getEmail();
}