package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.CoordinatorRequestDto;
import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;

import java.util.List;

public interface CoordinatorService {
    public Coordinator updateCoordinator(Long id , CoordinatorRequestDto coordinatorRequestDto);

    public void deleteCoordinator(Long id);

    Coordinator createCoordinator(CoordinatorRequestDto coordinatorRequestDto);

    CoordinatorResponseDto getCoordinator(Long id);

    List<CoordinatorResponseDto >GetAllCoordinator();

}
