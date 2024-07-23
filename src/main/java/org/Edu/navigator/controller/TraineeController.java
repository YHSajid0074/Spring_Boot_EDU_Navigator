package org.Edu.navigator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.common.constant.Message;
import org.Edu.navigator.common.routes.ApiConstants;
import org.Edu.navigator.common.routes.Router;
import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.service.Impl.TraineeServiceImpl;
import org.Edu.navigator.model.trainee.Trainee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path= Router.TRAINEE)
@Tag(name= ApiConstants.TRAINEE)
public class TraineeController {

    TraineeServiceImpl traineeServiceImpl;


    public TraineeController(TraineeServiceImpl traineeServiceImpl) {

        this.traineeServiceImpl = traineeServiceImpl;

    }


    @PostMapping(Router.CREATE_TRAINEE)
    public ResponseEntity<String> createTrainee(@RequestBody TraineeRequestDto traineeRequestDto) {

        traineeServiceImpl.createTrainee(traineeRequestDto);

        return ResponseEntity.ok(Message.CREATED_SUCCESSFULLY);
    }


    @PutMapping(Router.UPDATE_TRAINEE)
    public ResponseEntity<String> updateTrainee(@PathVariable Long id, @RequestBody TraineeRequestDto traineeRequestDto) {

        traineeServiceImpl.updateTrainee(id, traineeRequestDto);

        return ResponseEntity.ok(Message.UPDATED_SUCCESSFULLY);
    }


    @DeleteMapping(Router.DELETE_TRAINEE)
    public ResponseEntity<String> deleteTrainee(@PathVariable Long id) {

        traineeServiceImpl.deleteTrainee(id);

        return ResponseEntity.ok(Message.DELETED_SUCCESSFULLY);

    }


    @GetMapping(Router.GET_TRAINEE_BY_ID)
    public ResponseEntity<Trainee> getTraineeById(@PathVariable Long id) {

        Trainee trainee = traineeServiceImpl.getTraineeById(id);

        return ResponseEntity.ok(trainee);

    }


    @GetMapping(Router.GET_ALL_TRAINEE)
    public ResponseEntity<List<Trainee>> getAllTrainee() {

        return ResponseEntity.ok(traineeServiceImpl.getAllTrainees());

    }


}
