package ru.kingsbot.entity.conversation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversation")
@NoArgsConstructor
public class Conversation {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    public Conversation(Long id) {
        this.id = id;
    }

}
