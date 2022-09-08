package com.appcourse.repository;

import com.appcourse.entity.DailyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyNewsRepository extends JpaRepository<DailyNews,Long> {
}
