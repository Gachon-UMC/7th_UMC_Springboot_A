package umc.spring.domain.map.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMap is a Querydsl query type for Map
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMap extends EntityPathBase<Map> {

    private static final long serialVersionUID = 1578829936L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMap map = new QMap("map");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath location = createString("location");

    public final NumberPath<Long> mapId = createNumber("mapId", Long.class);

    public final umc.spring.domain.store.domain.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMap(String variable) {
        this(Map.class, forVariable(variable), INITS);
    }

    public QMap(Path<? extends Map> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMap(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMap(PathMetadata metadata, PathInits inits) {
        this(Map.class, metadata, inits);
    }

    public QMap(Class<? extends Map> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new umc.spring.domain.store.domain.QStore(forProperty("store"), inits.get("store")) : null;
    }

}

