package umc.spring.temp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import umc.spring.global.api.ApiResponse;
import umc.spring.temp.converter.TempConverter;
import umc.spring.temp.service.TempService.TempQueryService;
import umc.spring.temp.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

	private final TempQueryService tempQueryService;

	@GetMapping("/test")
	public ApiResponse<TempResponse.TempTestDTO> testAPI(){

		return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
	}

	@GetMapping("/exception")
	public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
		tempQueryService.CheckFlag(flag);
		return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
	}
}
