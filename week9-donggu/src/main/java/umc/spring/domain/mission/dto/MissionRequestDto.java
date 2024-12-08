package umc.spring.domain.mission.dto;

import lombok.Getter;

@Getter
public class MissionRequestDto {
	private long storeId;
	private int point;
	private String content;
	private int dueDate;
}
