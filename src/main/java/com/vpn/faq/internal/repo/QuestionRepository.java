package com.vpn.faq.internal.repo;

import com.vpn.faq.internal.infrastructure.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID> {

    @Query("SELECT DISTINCT q FROM QuestionEntity q LEFT JOIN FETCH q.answers")
    List<QuestionEntity> findAllWithAnswers();

    @Query(value = "SELECT * FROM questions " +
            "WHERE to_tsvector('russian', question) @@ plainto_tsquery('russian', :query) " +
            "OR question ILIKE CAST(CONCAT('%', :query, '%') AS TEXT)",
            nativeQuery = true)
    List<QuestionEntity> searchFuzzy(@Param("query") String query);
}