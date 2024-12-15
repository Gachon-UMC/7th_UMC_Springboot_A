package umc.spring.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QReview;
import umc.spring.domain.QStore;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;
    private final QReview review = QReview.review;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Integer rating) {
        BooleanBuilder predicate = new BooleanBuilder();


        if (name != null) {
            predicate.and(store.name.eq(name));
        }

        if (rating != null) {
            predicate.and(review.rating.goe(rating));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .leftJoin(store.storeReviews, review).fetchJoin() // Store와 Review 간 조인
                .where(predicate)
                .fetch();

        }



    }
