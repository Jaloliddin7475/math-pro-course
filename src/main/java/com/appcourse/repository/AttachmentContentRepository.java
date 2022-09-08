package com.appcourse.repository;

import com.appcourse.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Long> {
}
