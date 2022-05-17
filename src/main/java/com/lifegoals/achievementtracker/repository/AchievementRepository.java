package com.lifegoals.achievementtracker.repository;

import com.lifegoals.achievementtracker.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
