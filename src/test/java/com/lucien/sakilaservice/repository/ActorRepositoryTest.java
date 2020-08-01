package com.lucien.sakilaservice.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void testActor() {
        actorRepository.findAll();
    }
}
