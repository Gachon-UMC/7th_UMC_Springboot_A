package umc.spring.domain.question.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.answer.domain.Answer;
import umc.spring.domain.questionMedia.domain.QuestionMedia;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.shared.QuestionStatus;
import umc.spring.domain.shared.QuestionType;
import umc.spring.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10) DEFAULT 'WAITING'")
	@Enumerated(EnumType.STRING)
	private QuestionStatus questionStatus;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;

	@NotNull
	@Column
	private String title;

	@NotNull
	@Column
	private String content;

	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Answer answer;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<QuestionMedia> questionMediaList = new ArrayList<>();

	@Builder
	private Question(User user, QuestionType questionType, String title, String content) {
		this.user = user;
		this.questionStatus = QuestionStatus.WAITING;
		this.questionType = questionType;
		this.title = title;
		this.content = content;
	}
}
