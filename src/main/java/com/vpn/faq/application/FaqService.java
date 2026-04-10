package com.vpn.faq.application;

import com.vpn.faq.application.port.IFaqService;
import com.vpn.faq.internal.infrastructure.entity.AnswerEntity;
import com.vpn.faq.internal.infrastructure.entity.QuestionEntity;
import com.vpn.faq.internal.repo.AnswerRepository;
import com.vpn.faq.internal.repo.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaqService implements IFaqService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Transactional
    public QuestionEntity createQuestion(String questionText){
        QuestionEntity question = new QuestionEntity();
        question.setQuestion(questionText);
        return questionRepository.save(question);
    }

    @Transactional
    public AnswerEntity createAnswer(String answerText, UUID questionId){
        QuestionEntity question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Вопрос не найден"));

        AnswerEntity answer = new AnswerEntity();
        answer.setText(answerText);
        answer.setQuestion(question); // Исправил опечатку setQustion -> setQuestion

        return answerRepository.save(answer);
    }

    @Transactional
    public List<QuestionEntity> getAll(String search){
        if(search != null && !search.isBlank()){
            List<QuestionEntity> found = questionRepository.searchFuzzy(search);
            found.forEach(q -> q.getAnswers().size());
            return found;
        }
        return questionRepository.findAllWithAnswers();
    }
}