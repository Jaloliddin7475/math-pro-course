package com.appcourse.repository;

import com.appcourse.entity.Bob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BobRepository extends JpaRepository<Bob,Long> {
}
