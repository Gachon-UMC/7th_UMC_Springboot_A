package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.emums.StoreStatus;
import umc.spring.domain.mapping.Login;
import umc.spring.domain.mapping.Mission;
import umc.spring.domain.mapping.Region;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "stores")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StoreStatus status;

    @Column(length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;


    @Builder.Default
    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> storeReviews = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Mission> storeMissions = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder reviews = new StringBuilder();
        if (storeReviews != null && !storeReviews.isEmpty()) {
            storeReviews.forEach(review -> reviews.append("{rating=").append(review.getRating()).append(", comment=").append(review.getComment()).append("}, "));
        }

        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", region=" + (region != null ? region.getRegionName() : "N/A") +
                ", reviews=" + (!reviews.isEmpty() ? reviews.toString() : "No Reviews") +
                '}';
    }

   public void setRegion(Region region) {
        this.region = region;
   }



}
