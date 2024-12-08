package umc.spring.domain.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.answer.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
