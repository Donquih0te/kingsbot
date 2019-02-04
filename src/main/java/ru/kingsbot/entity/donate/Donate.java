package ru.kingsbot.entity.donate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "donate")
public class Donate {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Getter
    @Column(name = "customer", nullable = false)
    private Integer customer;

    @Getter
    @Column(name = "command", nullable = false)
    private String command;

    @Getter
    @Column(name = "sum", nullable = false)
    private Integer sum;

    @Getter
    @Column(name = "operation_number", nullable = false)
    private String operationNumber;

    @Getter
    @Column(name = "email", nullable = false)
    private String email;

    @Getter
    @Column(name = "phone", nullable = true)
    private String phone;

    @Getter
    @Column(name = "vault", nullable = false)
    private Integer vault;

    @Getter
    @Column(name = "sign", nullable = false)
    private String sign;

    @Getter
    @Setter
    @Column(name = "completed", nullable = false)
    private boolean completed;

}
