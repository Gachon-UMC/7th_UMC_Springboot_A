package umc.spring.global.temp.converter;

import umc.spring.global.temp.dto.TempResponse;

public class TempConverter {

	public static TempResponse.TempTestDTO toTempTestDTO(){
		return TempResponse.TempTestDTO.builder()
			.testString("This is Test!")
			.build();
	}

	public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
		return TempResponse.TempExceptionDTO.builder()
			.flag(flag)
			.build();
	}
}
