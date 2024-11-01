package umc.spring.domain.help.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.shared.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Help extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long helpId;

	@NotNull
	@Column
	private String helpContent;

	@NotNull
	@Column(length = 20)
	private String helpCategory;

	@Builder
	private Help(String helpContent, String helpCategory) {
		this.helpContent = helpContent;
		this.helpCategory = helpCategory;
	}
}
