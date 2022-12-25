package com.example.finalprojectapifinal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long questionId;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "questionRating")
    private List<UserQuestionRating> questions;

    public Question(long Id){
        questionId = Id;
    }
}
