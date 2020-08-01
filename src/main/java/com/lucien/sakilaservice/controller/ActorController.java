package com.lucien.sakilaservice.controller;

import com.lucien.sakilaservice.constant.RequestPath;
import com.lucien.sakilaservice.model.ActorVo;
import com.lucien.sakilaservice.service.ActorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;


@RestController
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = notNull(actorService);
    }

    @GetMapping(value = RequestPath.GET_ALL_ACTORS, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActorVo> getAllActors() {
        return actorService.findAll();
    }

    @GetMapping(value = RequestPath.GET_ACTOR, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActorVo getActorById(@PathVariable long id) {
        return actorService.findById(id);
    }

    @GetMapping(value = RequestPath.GET_ACTOR_BY_FILTER, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActorVo> getActorsByFilter(@RequestParam String filter) {
        return actorService.findByFilter(filter);
    }

    @PostMapping(value = RequestPath.CREATE_ACTOR, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ActorVo createActor(@RequestBody ActorVo actorVo) {
        return actorService.addActor(actorVo);
    }

    @PutMapping(value = RequestPath.UPDATE_ACTOR, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActorVo updateActor(@RequestBody ActorVo actorVo) {
        return actorService.updateActor(actorVo);
    }
}
