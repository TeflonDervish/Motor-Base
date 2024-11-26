package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "userFromId")
    private Users userFrom;

    @ManyToOne
    @JoinColumn(name = "userToId")
    private Users userTo;

    private String comment;
    private Double grade;

}
