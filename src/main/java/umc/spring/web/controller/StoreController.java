package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.Vaildator.annotation.CheckPage;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.service.ReviewService.ReviewQueryServiceImpl;
import umc.spring.service.StoreService.StoreQueryServiceImpl;
import umc.spring.web.controller.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.controller.dto.ReviewDTO.ReviewResponseDTO;
import umc.spring.web.controller.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.controller.dto.StoreDTO.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreController {

    private final StoreQueryServiceImpl storeQueryService;


    @PostMapping("{regionId}")
    public ApiResponse<StoreResponseDTO.JoinResultDTO>
    join(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreRequestDTO.joinStoreDTO request
    ) {
        StoreResponseDTO.JoinResultDTO result = storeQueryService.joinStore(regionId, request);
        return ApiResponse.onSuccess(storeQueryService.joinStore(regionId, request));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(
            summary = "특정 가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰들을 조회하는 API로, 페이징 처리 기능을 제공합니다. query string으로 page 번호를 전달해야 합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 ID (PathVariable)", required = true),
            @Parameter(name = "page", description = "페이징 처리용 페이지 번호 (Query String)", required = true)
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        // Service 호출 및 결과 반환
        StoreResponseDTO.ReviewPreViewListDTO reviewListDTO = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(reviewListDTO);
    }


}
