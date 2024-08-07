package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.DirectorRequestDto;
import org.Edu.navigator.dto.response.DirectorResponseDto;
import org.Edu.navigator.model.director.Director;

import java.util.List;

public interface DirectorService {

    List<DirectorResponseDto> getAllDirectors();

    DirectorResponseDto getDirectorById(Long id);

    Director createDirector(DirectorRequestDto directorRequestDto);

    Director updateDirector(Long id, DirectorRequestDto directorRequestDto);

    void deleteDirector(Long id);

}
