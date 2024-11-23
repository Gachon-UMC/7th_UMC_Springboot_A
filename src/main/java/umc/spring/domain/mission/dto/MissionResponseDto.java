package umc.spring.domain.mission.dto;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Builder;
import lombok.Getter;

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
}
