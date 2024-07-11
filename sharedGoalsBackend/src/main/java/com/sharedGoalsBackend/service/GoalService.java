package com.sharedGoalsBackend.service;

import com.sharedGoalsBackend.Repositories.GoalRepository;
import com.sharedGoalsBackend.entity.Goal;
import com.sharedGoalsBackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public void addMember(Long goalId, User user) {
        Goal goal = goalRepository.findById(goalId).orElseThrow(() -> new ResourceNotFoundException("Goal not found"));
        goal.getMembers().add(user);
        goalRepository.save(goal);
    }

    // Other service methods for managing goals
}

