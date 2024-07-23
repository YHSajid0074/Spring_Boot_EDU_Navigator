package org.Edu.navigator.service.Impl;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.TrainerRequestDto;
import org.Edu.navigator.exception.DuplicateEmailException;
import org.Edu.navigator.model.Trainer;
import org.Edu.navigator.repository.TrainerRepositories;
import org.Edu.navigator.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    TrainerRepositories trainerRepositories;

    public TrainerServiceImpl(TrainerRepositories trainerRepositories) {
        this.trainerRepositories = trainerRepositories;
    }

    @Override
    public List<Trainer> getAllTrainers() {

        return trainerRepositories.findAll();

    }

    @Override
    public Trainer getTrainerById(Long id) {

        return trainerRepositories.getOne(id);

    }

    @Override
    public Trainer getTrainerByName(String name) {
        return null;
    }

    @Override
    public Trainer createTrainer(TrainerRequestDto trainerRequestDto) {

        Trainer email = trainerRepositories.findByEmail(trainerRequestDto.email());

        if (email != null) {
            throw new DuplicateEmailException("Email already exists");
        }

        Trainer trainer = new Trainer();

        trainer.setCoordinator(trainerRequestDto.coordinator());
        trainer.setUsername(trainerRequestDto.username());
        trainer.setEmail(trainerRequestDto.email());
        trainer.setTrainees(trainerRequestDto.trainees());
        trainer.setFullName(trainerRequestDto.fullName());

        return trainerRepositories.save(trainer);
    }


    @Override
    public Trainer updateTrainer(Long id, TrainerRequestDto trainerRequestDto) {

        Trainer email = trainerRepositories.findByEmail(trainerRequestDto.email());

        if (email != null) {
            throw new DuplicateEmailException("Email already exists");
        }

        Trainer trainer = trainerRepositories.getOne(id);

        trainer.setCoordinator(trainerRequestDto.coordinator());
        trainer.setUsername(trainerRequestDto.username());
        trainer.setEmail(trainerRequestDto.email());
        trainer.setTrainees(trainerRequestDto.trainees());
        trainer.setFullName(trainerRequestDto.fullName());

        return trainerRepositories.save(trainer);
    }


    @Override
    public void deleteTrainer(Long id) {

        trainerRepositories.deleteById(id);

    }


}
