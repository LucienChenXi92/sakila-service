package com.lucien.sakilaservice.service;

import com.lucien.sakilaservice.model.ActorVo;

import java.util.List;

public interface ActorService {

    List<ActorVo> findAll();

    ActorVo findById(long id);

    List<ActorVo> findByFilter(String filter);

    ActorVo addActor(ActorVo actorVo);

    ActorVo updateActor(ActorVo actorVo);
}
