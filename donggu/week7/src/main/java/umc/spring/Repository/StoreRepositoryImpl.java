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
