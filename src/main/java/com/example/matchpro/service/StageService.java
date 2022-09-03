package com.example.matchpro.service;

import com.example.matchpro.model.Stage;
import com.example.matchpro.repository.IStageRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * The {@link IStageService} implementation.
 *
 * @author Alben Bustamante
 */
@Service
@RequiredArgsConstructor
public class StageService extends CrudService<Stage> implements IStageService {

    private final IStageRepository repository;

    @Override
    protected CrudRepository<Stage, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Stage> update(long id, Stage stage) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        stage.setStageId(id);

        return Optional.of(repository.save(stage));
    }

    @Override
    public Optional<Stage> getByName(String name) {
        return repository.findByName(name);
    }

}
