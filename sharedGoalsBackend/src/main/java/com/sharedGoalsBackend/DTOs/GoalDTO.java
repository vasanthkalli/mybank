package com.sharedGoalsBackend.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GoalDTO {
    private String name;
    private Double targetAmount;
    private LocalDateTime endDate;
    // Getters and Setters
}

