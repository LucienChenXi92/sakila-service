package com.lucien.sakilaservice.entity;

import com.lucien.sakilaservice.model.ActorVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "actor")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", unique = true, nullable = false)
    private long actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    public static Actor convert(ActorVo vo) {
        if (vo == null) {
            return null;
        }
        return Actor.builder()
                .actorId(vo.getActorId())
                .firstName(vo.getFirstName())
                .lastName(vo.getLastName())
                .lastUpdate(vo.getLastUpdate())
                .build();
    }
}
