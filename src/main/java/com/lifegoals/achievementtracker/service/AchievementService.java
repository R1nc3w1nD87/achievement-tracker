package com.lifegoals.achievementtracker.service;

import com.lifegoals.achievementtracker.dto.AchievementDTO;
import com.lifegoals.achievementtracker.entity.Achievement;
import com.lifegoals.achievementtracker.repository.AchievementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record AchievementService(
        AchievementRepository achievementRepository,
        ModelMapper modelMapper) {
    @Autowired
    public AchievementService {
    }

    public AchievementDTO createAchievement(AchievementDTO achievementDetails) {
        return modelMapper.map(
                achievementRepository.save(
                        modelMapper.map(achievementDetails, Achievement.class))
                , AchievementDTO.class);

    }

    public AchievementDTO findAchievementById(Long id) {
        return modelMapper.map(achievementRepository.findById(id), AchievementDTO.class);
    }

    public List<AchievementDTO> findAllAchievements() {
        return achievementRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, AchievementDTO.class))
                .collect(Collectors.toList());
    }

    public AchievementDTO updateAchievement(Long id, AchievementDTO newAchievementDetails) {
        Achievement achievementToUpdate = achievementRepository.findById(id).get();
        achievementToUpdate.setFullName(newAchievementDetails.getFullName());
        achievementToUpdate.setAchievement(newAchievementDetails.getAchievement());
        achievementRepository.save(achievementToUpdate);
        return modelMapper.map(achievementToUpdate, AchievementDTO.class);
    }

    public void deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
    }

}
