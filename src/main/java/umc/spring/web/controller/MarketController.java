package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.Market;
import umc.spring.validation.CheckPage;
import umc.spring.web.dto.MarketRegisterDto;
import umc.spring.service.MarketService.MarketService;
import umc.spring.web.dto.MarketResponseDto;

@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @PostMapping
    public ResponseEntity<Market> registerMarket(@Valid @RequestBody MarketRegisterDto dto) {
        Market createdMarket = marketService.addMarket(dto);
        return ResponseEntity.ok(createdMarket);
    }

    @GetMapping("/{marketId}/missions")
    public ResponseEntity<MarketResponseDto.MissionListResponseDto> getMarketMissions(
            @PathVariable(name = "marketId") Long marketId, // 명시적으로 이름 추가
            @CheckPage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        MarketResponseDto.MissionListResponseDto response = marketService.getMarketMissions(marketId, page - 1, size);
        return ResponseEntity.ok(response);
    }

}
