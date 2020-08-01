package com.lucien.sakilaservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucien.sakilaservice.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorVo {

    @JsonProperty(value = "Actor Id")
    private long actorId;

    @JsonProperty(value = "First Name")
    private String firstName;

    @JsonProperty(value = "Last Name")
    private String lastName;

    @JsonProperty(value = "Last Update")
    private Date lastUpdate;

    public static ActorVo convert(Actor actor) {
        if (actor == null) {
            return null;
        }
        return ActorVo.builder()
                .actorId(actor.getActorId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .lastUpdate(actor.getLastUpdate())
                .build();
    }
}
