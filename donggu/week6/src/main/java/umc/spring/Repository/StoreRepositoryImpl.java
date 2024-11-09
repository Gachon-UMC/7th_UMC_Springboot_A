package umc.spring.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.store.domain.QStore;
import umc.spring.domain.store.domain.Store;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {
	private final JPAQueryFactory jpaQueryFactory;
	private final QStore store = QStore.store;

	@Override
	public List<Store> dynamicQueryWithBooleanBuilder(String storeName, Float avgRating) {
		BooleanBuilder predicate = new BooleanBuilder();

		if (storeName != null) {
			predicate.and(store.storeName.eq(storeName)); // storeName 필드로 수정
		}

		if (avgRating != null) {
			predicate.and(store.avgRating.goe(avgRating)); // avgRating 필드로 수정
		}

		return jpaQueryFactory
			.selectFrom(store)
			.where(predicate)
			.fetch();
	}
}

/*
INSERT INTO region (id, name, created_at, updated_at)
VALUES (1, '서울', NOW(), NOW()),
	(2, '부산', NOW(), NOW()),
	(3, '인천', NOW(), NOW());

INSERT INTO store (id, name, address, score, region_id, created_at, updated_at)
VALUES (1, 'Store 1', '서울시 서대문구 이화여대길 52', 4.5, 1, NOW(), NOW()),
	(2, 'Store 2', '서울시 마포구 연남동', 3.8, 1, NOW(), NOW()),
	(3, 'Store 3', '서울시 동작구 흑석동', 2.2, 1, NOW(), NOW()),
	(4, '요아정', '서울시 용산구 이태원동', 4.0, 1, NOW(), NOW()),
	(5, '요아정', '서울시 서대문구 이화여대길 52', 3.2, 1, NOW(), NOW()),
	(6, '요아정', '서울시 강남구 대치동', 4.5, 1, NOW(), NOW());

INSERT INTO mission (id, mission_spec, store_id, created_at, updated_at)
VALUES (1, 'Store 1-미션 1', 1, NOW(), NOW()),
	(2, 'Store 1-미션 2', 1, NOW(), NOW()),
	(3, 'Store 2-미션 1', 2, NOW(), NOW()),
	(4, 'Store 3-미션 1', 3, NOW(), NOW());

INSERT INTO review (id, body, score, store_id, created_at, updated_at)
VALUES (1, '너무 좋아요!', 5.0, 1, NOW(), NOW()),
	(2, '분위기 짱~', 3.0, 1, NOW(), NOW()),
	(3, '서비스가 좋습니다', 4.8, 2, NOW(), NOW()),
	(4, '음식이 맛있고 사장님이 친절해요', 4.5, 3, NOW(), NOW());  */
