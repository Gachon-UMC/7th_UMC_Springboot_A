package umc.spring.domain.store.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -907001712L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    public final NumberPath<Float> avgRating = createNumber("avgRating", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.map.domain.QMap map;

    public final ListPath<umc.spring.domain.review.domain.Review, umc.spring.domain.review.domain.QReview> reviewList = this.<umc.spring.domain.review.domain.Review, umc.spring.domain.review.domain.QReview>createList("reviewList", umc.spring.domain.review.domain.Review.class, umc.spring.domain.review.domain.QReview.class, PathInits.DIRECT2);

    public final StringPath storeBackgroundImageUrl = createString("storeBackgroundImageUrl");

    public final StringPath storeCategory = createString("storeCategory");

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final StringPath storeLocation = createString("storeLocation");

    public final StringPath storeName = createString("storeName");

    public final EnumPath<umc.spring.domain.shared.StoreStatus> storeStatus = createEnum("storeStatus", umc.spring.domain.shared.StoreStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.map = inits.isInitialized("map") ? new umc.spring.domain.map.domain.QMap(forProperty("map"), inits.get("map")) : null;
    }

}

