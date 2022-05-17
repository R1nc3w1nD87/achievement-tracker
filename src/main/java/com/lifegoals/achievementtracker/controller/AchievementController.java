package com.lifegoals.achievementtracker.controller;

import com.lifegoals.achievementtracker.dto.AchievementDTO;
import com.lifegoals.achievementtracker.service.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
    class AchievementController {
    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping
    public List<AchievementDTO> findAll(){
        return achievementService.findAllAchievements();
    }

    @GetMapping(value = "/{id}")
    public AchievementDTO findById(@PathVariable("id") Long id){
        return achievementService.findAchievementById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AchievementDTO create(@RequestBody AchievementDTO achievement){
        return achievementService.createAchievement(achievement);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AchievementDTO update(@PathVariable("id") Long id, @RequestBody AchievementDTO details){
        return achievementService.updateAchievement(id, details);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        achievementService.deleteAchievement(id);
    }
}
