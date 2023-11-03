package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
