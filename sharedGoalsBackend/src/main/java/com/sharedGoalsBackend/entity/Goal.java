package com.sharedGoalsBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "goal_Entity")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "goalID")
    private UUID goal_id;
    private String name;
    private Double targetAmount;
    private Double currentAmount = 0.0;
    private LocalDateTime endDate;

    @ManyToOne
    private User primaryUser;

    @ManyToMany
    @JoinTable(name = "goal_members",
            joinColumns = @JoinColumn(name = "goal_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> members = new HashSet<>();
}
