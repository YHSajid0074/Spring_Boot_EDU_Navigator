package org.Edu.navigator.Dto;

import org.Edu.navigator.entities.Coordinator;

/**
 * Projection for {@link Coordinator}
 */
public interface CustomCoordinatorResponseDto {
    Long getId();

    String getFullName();

    String getEmail();
}