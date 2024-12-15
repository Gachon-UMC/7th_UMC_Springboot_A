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
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.web.controller.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.controller.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/mission")
public class MissionController {

    private final MissionQueryService missionService;

    @PostMapping("/add")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.JoinAddMissionDTO request){
        return ApiResponse.onSuccess(missionService.JoinDTO(request));
    }


    @GetMapping("/{storeId}/missions")
    @Operation(
            summary = "특정 가게의 미션 목록 조회 API",
            description = "특정 가게의 미션 목록을 페이징 처리하여 반환합니다. 페이지 번호는 1 이상의 값이어야 합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 목록 조회 성공",
                    content = @Content(schema = @Schema(implementation = MissionResponseDTO.PagedMissionDTO.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게가 존재하지 않음",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "페이지 번호가 잘못됨",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 ID, PathVariable로 전달됩니다.", required = true),
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 정수로 Query String으로 전달됩니다.", required = true)
    })
    public ApiResponse<MissionResponseDTO.PagedMissionDTO> getMissionsByStore(
            @PathVariable Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        MissionResponseDTO.PagedMissionDTO response = missionService.getMissionsByStore(storeId, page - 1);
        return ApiResponse.onSuccess(response);
    }

}
