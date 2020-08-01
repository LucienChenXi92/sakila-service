package com.lucien.sakilaservice.service.impl;

import com.lucien.sakilaservice.entity.Actor;
import com.lucien.sakilaservice.model.ActorVo;
import com.lucien.sakilaservice.repository.ActorRepository;
import com.lucien.sakilaservice.service.ActorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.Validate.notNull;

@Service
public class ActorServiceImpl implements ActorService {


    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = notNull(actorRepository);
    }

    @Override
    public List<ActorVo> findAll() {
        List<Actor> actors = actorRepository.findAll();
        return actors.stream().map(ActorVo::convert).collect(Collectors.toList());
    }

    @Override
    public ActorVo findById(long id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        return ActorVo.convert(actor);
    }

    @Override
    public List<ActorVo> findByFilter(String filter) {
        List<Actor> actors = actorRepository.findActorsByFilter(filter);
        return actors.stream().map(ActorVo::convert).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ActorVo addActor(ActorVo actorVo) {
        Actor actor = actorRepository.save(Actor.convert(actorVo));
        return ActorVo.convert(actor);
    }

    @Override
    @Transactional
    public ActorVo updateActor(ActorVo actorVo) {
        Optional<Actor> actorOpt = actorRepository.findById(actorVo.getActorId());
        if (!actorOpt.isPresent()) {
            // throw errors
        }
        Actor actor = actorRepository.saveAndFlush( Actor.convert(actorVo));
        return ActorVo.convert(actor);
    }

}
