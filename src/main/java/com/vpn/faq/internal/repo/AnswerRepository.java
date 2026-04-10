package com.vpn.faq.internal.repo;

import com.vpn.faq.internal.infrastructure.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnswerRepository extends JpaRepository<AnswerEntity, UUID> {
}
