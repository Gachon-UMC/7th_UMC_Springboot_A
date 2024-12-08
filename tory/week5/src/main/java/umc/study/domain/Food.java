package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Column(nullable = false, length = 45)
    private String foodCategory;

    @OneToMany(mappedBy = "food", cascade=CascadeType.ALL)
    private List<Store> storeList=new ArrayList<>();

    @OneToMany(mappedBy = "food", cascade=CascadeType.ALL)
    private List<UserPrefer> userPreferList=new ArrayList<>();

}