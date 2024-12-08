package umc.spring.domain.mission.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDto {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	@Getter
	@Builder
	public static class addMissionResultDto {
		Long missionId;
		LocalDateTime createdAt;
	}

	@Getter
	@Builder
	public static class addUserMissionResultDto {
		Long userMissionId;
		LocalDateTime createdAt;
	}

	@Getter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class missionPreviewDto{
		String storeName;
		String category;
		String body;
		int point;
		int dueDate;
	}

	@Getter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class missionPreviewListDto {
		List<missionPreviewDto> missionList;
		Integer listSize;
		Integer totalPage;
		Long totalElements;
		Boolean isFirst;
		Boolean isLast;
		Integer currentPage;
	}

	@Getter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class myMissionPreviewDto{
		String storeName;
		String nickName;
		String category;
		String body;
		int point;
		int dueDate;
	}

	@Getter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class myMissionPreviewListDto {
		List<myMissionPreviewDto> myMissionList;
		Integer listSize;
		Integer totalPage;
		Long totalElements;
		Boolean isFirst;
		Boolean isLast;
		Integer currentPage;
	}
}
