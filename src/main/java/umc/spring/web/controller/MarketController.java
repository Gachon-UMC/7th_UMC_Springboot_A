package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.Market;
import umc.spring.web.dto.MarketRegisterDto;
import umc.spring.service.MarketService.MarketService;

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
}
