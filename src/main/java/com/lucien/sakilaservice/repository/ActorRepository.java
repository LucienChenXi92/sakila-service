package com.lucien.sakilaservice.repository;

import com.lucien.sakilaservice.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query(value = "SELECT * FROM actor WHERE last_name LIKE %?1% OR first_name LIKE %?1%", nativeQuery = true)
    List<Actor> findActorsByFilter(String filter);

};
