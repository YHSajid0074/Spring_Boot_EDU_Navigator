package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.CoordinatorRequestDto;
import org.Edu.navigator.model.Coordinator;
import org.Edu.navigator.service.Impl.CoordinatorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("coordinator")
public class CoordinatorController {

    public final CoordinatorServiceImpl coordinatorServiceImpl;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody CoordinatorRequestDto coordinator) {

        coordinatorServiceImpl.createCoordinator(coordinator);

        return ResponseEntity.ok("Successfully Created");
    }


    @GetMapping("{id}")
    public ResponseEntity<Coordinator> Get(@PathVariable Long id) {

        return ResponseEntity.ok(coordinatorServiceImpl.getCoordinator(id));

    }


    @GetMapping("getAll")
    public ResponseEntity<List<Coordinator>> GetAll() {

        return ResponseEntity.ok(coordinatorServiceImpl.GetAllCoordinator());

    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        coordinatorServiceImpl.deleteCoordinator(id);

        return ResponseEntity.ok("Successfully Deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CoordinatorRequestDto coordinatorRequestDto) {

        coordinatorServiceImpl.updateCoordinator(id, coordinatorRequestDto);

        return ResponseEntity.ok("Successfully Updated");

    }

}