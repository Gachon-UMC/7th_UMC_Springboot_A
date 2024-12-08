package umc.spring.domain.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Market;
import umc.spring.global.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer missionPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id") // 외래 키 설정
    private Market market;
}
