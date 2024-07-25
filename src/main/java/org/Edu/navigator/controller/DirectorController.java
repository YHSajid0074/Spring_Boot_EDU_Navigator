package org.Edu.navigator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.common.constant.Message;
import org.Edu.navigator.common.routes.ApiConstants;
import org.Edu.navigator.common.routes.Router;
import org.Edu.navigator.dto.request.DirectorRequestDto;
import org.Edu.navigator.dto.response.DirectorResponseDto;
import org.Edu.navigator.model.director.Director;
import org.Edu.navigator.service.Impl.DirectorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ApiConstants.DIRECTOR)
@Tag(name= ApiConstants.DIRECTOR)

public class DirectorController {


    private final DirectorServiceImpl directorServiceImpl;


    @PostMapping(Router.CREATE_DIRECTOR)
    public ResponseEntity<String> create(DirectorRequestDto directorRequestDto) {

        directorServiceImpl.createDirector(directorRequestDto);

        return ResponseEntity.ok(Message.CREATED_SUCCESSFULLY);

    }


    @GetMapping(Router.GET_DIRECTOR_BY_ID)
    public ResponseEntity<DirectorResponseDto> getById(@PathVariable Long id) {

        DirectorResponseDto directorResponseDto = directorServiceImpl.getDirectorById(id);

        return ResponseEntity.ok(directorResponseDto);

    }


    @GetMapping(Router.GET_ALL_DIRECTOR)
    public ResponseEntity<List<DirectorResponseDto>> getAll() {

        List<DirectorResponseDto> directors = directorServiceImpl.getAllDirectors();

        return ResponseEntity.ok(directors);
    }


    @DeleteMapping(Router.DELETE_DIRECTOR)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        directorServiceImpl.deleteDirector(id);

        return ResponseEntity.ok(Message.DELETED_SUCCESSFULLY);
    }

}
