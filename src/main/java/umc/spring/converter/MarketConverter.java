package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Market;
import umc.spring.web.dto.MarketRegisterDto;

@Component
public class MarketConverter {

    public Market toEntity(MarketRegisterDto dto) {
        return Market.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .openTime(dto.getOpenTime())
                .closedTime(dto.getClosedTime())
                .score(dto.getScore())
                .build();
    }
}
