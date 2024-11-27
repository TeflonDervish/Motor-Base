package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@Entity
public class UserFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "userFromId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users userFrom;

    @ManyToOne
    @JoinColumn(name = "userToId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users userTo;

    private String comment;
    private Double grade;

}
