package umc.spring.Repository;

import java.util.List;

import umc.spring.domain.store.domain.Store;


public interface StoreRepositoryCustom {
	List<Store> dynamicQueryWithBooleanBuilder(String storeName, Float avgRating);
}