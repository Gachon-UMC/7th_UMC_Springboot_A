package umc.spring.domain.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.question.domain.Question;

public interface questionRepository extends JpaRepository<Question, Long> {
}
