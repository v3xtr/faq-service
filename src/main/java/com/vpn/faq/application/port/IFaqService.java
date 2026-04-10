package com.vpn.faq.application.port;

import com.vpn.faq.internal.infrastructure.entity.AnswerEntity;
import com.vpn.faq.internal.infrastructure.entity.QuestionEntity;

import java.util.List;
import java.util.UUID;

public interface IFaqService {
    QuestionEntity createQuestion(String questionText);
    AnswerEntity createAnswer(String answerText, UUID questionId);
    List<QuestionEntity> getAll(String search);
}
