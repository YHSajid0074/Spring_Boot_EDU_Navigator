package org.Edu.navigator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.common.constant.Message;
import org.Edu.navigator.common.routes.ApiConstants;
import org.Edu.navigator.common.routes.Router;
import org.Edu.navigator.dto.request.TrainerRequestDto;
import org.Edu.navigator.dto.response.TrainerResponseDto;
import org.Edu.navigator.service.Impl.TrainerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path= Router.TRAINER)
@Tag(name= ApiConstants.TRAINER)
public class TrainerController {


    private final TrainerServiceImpl trainerServiceImpl;


    @GetMapping(Router.GET_TRAINER_BY_ID)
    public ResponseEntity<TrainerResponseDto> getTrainerById(@PathVariable Long id) {

        TrainerResponseDto trainer = trainerServiceImpl.getTrainerById(id);

        return ResponseEntity.ok(trainer);

    }


    @PutMapping(Router.UPDATE_TRAINER)
    public ResponseEntity<String> updateTrainer(@PathVariable Long id, @RequestBody TrainerRequestDto trainer) {

        trainerServiceImpl.updateTrainer(id, trainer);

        return ResponseEntity.ok(Message.UPDATED_SUCCESSFULLY);

    }


    @DeleteMapping(Router.DELETE_TRAINER)
    public ResponseEntity<String> deleteTrainer(@PathVariable Long id) {

        trainerServiceImpl.deleteTrainer(id);

        return ResponseEntity.ok(Message.DELETED_SUCCESSFULLY);
    }


    @PostMapping(Router.CREATE_TRAINER)
    public ResponseEntity<String> addTrainer(@RequestBody TrainerRequestDto trainerRequestDto) {

        trainerServiceImpl.createTrainer(trainerRequestDto);

        return ResponseEntity.ok(Message.CREATED_SUCCESSFULLY);
    }


    @GetMapping(Router.GET_ALL_TRAINER)
    public ResponseEntity<List<TrainerResponseDto>> getAllTrainers() {

        List<TrainerResponseDto> trainers = trainerServiceImpl.getAllTrainers();

        return ResponseEntity.ok(trainers);

    }
}
