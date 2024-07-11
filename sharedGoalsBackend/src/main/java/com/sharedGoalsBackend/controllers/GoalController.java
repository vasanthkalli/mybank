package com.sharedGoalsBackend.controllers;

import com.sharedGoalsBackend.DTOs.GoalDTO;
import com.sharedGoalsBackend.DTOs.UserDTO;
import com.sharedGoalsBackend.entity.Goal;
import com.sharedGoalsBackend.entity.User;
import com.sharedGoalsBackend.service.GoalService;
import com.sharedGoalsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goals")
public class GoalController {
    @Autowired
    private GoalService goalService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody GoalDTO goalDTO) {
        Goal goal = new Goal();
        goal.setName(goalDTO.getName());
        goal.setTargetAmount(goalDTO.getTargetAmount());
        goal.setEndDate(goalDTO.getEndDate());
        Goal createdGoal = goalService.createGoal(goal);
        return ResponseEntity.ok(createdGoal);
    }

    @PostMapping("/{goalId}/addMember")
    public ResponseEntity<Void> addMember(@PathVariable Long goalId, @RequestBody UserDTO userDTO) {
        User user = userService.findByUsername(userDTO.getUsername()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        goalService.addMember(goalId, user);
        return ResponseEntity.ok().build();
    }

    // Other goal-related endpoints
}

