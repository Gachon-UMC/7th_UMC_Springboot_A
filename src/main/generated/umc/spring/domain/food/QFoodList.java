package umc.spring.domain.food;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodList is a Querydsl query type for FoodList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodList extends EntityPathBase<FoodList> {

    private static final long serialVersionUID = -553997120L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodList foodList = new QFoodList("foodList");

    public final umc.spring.global.QBaseEntity _super = new umc.spring.global.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<Food> food = createEnum("food", Food.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.user.QUsers user;

    public QFoodList(String variable) {
        this(FoodList.class, forVariable(variable), INITS);
    }

    public QFoodList(Path<? extends FoodList> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodList(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodList(PathMetadata metadata, PathInits inits) {
        this(FoodList.class, metadata, inits);
    }

    public QFoodList(Class<? extends FoodList> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new umc.spring.domain.user.QUsers(forProperty("user")) : null;
    }

}

