package com.mateuszwalczyk.heroapp.repository;

import com.mateuszwalczyk.heroapp.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
