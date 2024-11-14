package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPrefer is a Querydsl query type for UserPrefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPrefer extends EntityPathBase<UserPrefer> {

    private static final long serialVersionUID = -961221497L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPrefer userPrefer = new QUserPrefer("userPrefer");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.foodCategory.domain.QFoodCategory foodCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.user.domain.QUser user;

    public final NumberPath<Long> userPreferId = createNumber("userPreferId", Long.class);

    public QUserPrefer(String variable) {
        this(UserPrefer.class, forVariable(variable), INITS);
    }

    public QUserPrefer(Path<? extends UserPrefer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPrefer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPrefer(PathMetadata metadata, PathInits inits) {
        this(UserPrefer.class, metadata, inits);
    }

    public QUserPrefer(Class<? extends UserPrefer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.foodCategory.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

