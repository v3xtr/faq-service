package com.vpn.faq.delivery.http;


import com.vpn.faq.application.FaqService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.vpn.faq.internal.domain.DTO.questionRequestDTO;
import com.vpn.faq.internal.domain.DTO.answerRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/faq")
@RequiredArgsConstructor
@Slf4j
public class FaqDelivery {

    private final FaqService faqService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) String search) {
        try {
            return ResponseEntity.ok(faqService.getAll(search));
        } catch (Exception e) {
            log.error("Error fetching FAQ", e);
            return ResponseEntity.internalServerError().body("Ошибка при получении данных");
        }
    }

    @PostMapping("/question")
    public ResponseEntity<?> createQuestion(@Valid @RequestBody questionRequestDTO questionRequest) {
        try {
            var result = faqService.createQuestion(questionRequest.getQuestionBody());
            return ResponseEntity.status(201).body(result);
        } catch (Exception e) {
            log.error("Error creating question", e);
            return ResponseEntity.internalServerError().body("Не удалось создать вопрос");
        }
    }

    @PostMapping("/answer")
    public ResponseEntity<?> createAnswer(@Valid @RequestBody answerRequestDTO answerRequest) {
        try {
            var result = faqService.createAnswer(
                    answerRequest.getAnswer(),
                    UUID.fromString(answerRequest.getQuestionId())
            );
            return ResponseEntity.status(201).body(result);
        } catch (IllegalArgumentException e) {
            log.error("Invalid UUID format: {}", answerRequest.getQuestionId());
            return ResponseEntity.badRequest().body("Неверный формат ID вопроса");
        } catch (Exception e) {
            log.error("Error creating answer", e);
            return ResponseEntity.internalServerError().body("Не удалось создать ответ");
        }
    }
}