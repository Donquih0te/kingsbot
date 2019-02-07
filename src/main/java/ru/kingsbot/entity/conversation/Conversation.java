package ru.kingsbot.entity.conversation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversation")
@ToString
@EqualsAndHashCode
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
