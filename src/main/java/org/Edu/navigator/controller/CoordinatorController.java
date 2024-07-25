package org.Edu.navigator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.common.constant.Message;
import org.Edu.navigator.common.routes.ApiConstants;
import org.Edu.navigator.common.routes.Router;
import org.Edu.navigator.dto.request.CoordinatorRequestDto;
import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.Edu.navigator.service.Impl.CoordinatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path= Router.COORDINATOR)
@Tag(name= ApiConstants.COORDINATOR)

public class CoordinatorController {

    public final CoordinatorServiceImpl coordinatorServiceImpl;


    @PostMapping(path= Router.CREATE_COORDINATOR)
    public ResponseEntity<String> create(@RequestBody CoordinatorRequestDto coordinator) {

        coordinatorServiceImpl.createCoordinator(coordinator);

        return ResponseEntity.ok(Message.CREATED_SUCCESSFULLY);
    }


    @GetMapping(Router.GET_COORDINATOR_BY_ID)
    public ResponseEntity<CoordinatorResponseDto> Get(@PathVariable Long id) {

        return ResponseEntity.ok(coordinatorServiceImpl.getCoordinator(id));

    }


    @GetMapping(Router.GET_ALL_COORDINATOR)
    public ResponseEntity<List<CoordinatorResponseDto>> GetAll() {

        return ResponseEntity.ok(coordinatorServiceImpl.GetAllCoordinator());

    }


    @DeleteMapping(Router.DELETE_COORDINATOR)
    public ResponseEntity <String> delete(@PathVariable Long id) {

        coordinatorServiceImpl.deleteCoordinator(id);

        return ResponseEntity.ok(Message.DELETED_SUCCESSFULLY);
    }


    @PutMapping(Router.UPDATE_COORDINATOR)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CoordinatorRequestDto coordinatorRequestDto) {

        coordinatorServiceImpl.updateCoordinator(id, coordinatorRequestDto);

        return ResponseEntity.ok(Message.UPDATED_SUCCESSFULLY);

    }

}