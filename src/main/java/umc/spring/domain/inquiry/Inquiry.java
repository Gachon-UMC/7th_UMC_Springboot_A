package umc.spring.domain.inquiry;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.global.BaseEntity;
import umc.spring.domain.user.Users;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    private String content;

    private InquiryStatus status;

}
