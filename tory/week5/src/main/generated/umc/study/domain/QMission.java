package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -200839606L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final DateTimePath<java.time.LocalDateTime> completeTime = createDateTime("completeTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> earnablePoint = createNumber("earnablePoint", Integer.class);

    public final StringPath missionDescription = createString("missionDescription");

    public final NumberPath<Integer> missionDueDate = createNumber("missionDueDate", Integer.class);

    public final NumberPath<Integer> missionId = createNumber("missionId", Integer.class);

    public final StringPath missionTitle = createString("missionTitle");

    public final StringPath restaurantCategory = createString("restaurantCategory");

    public final EnumPath<umc.study.domain.enums.MissionStatus> status = createEnum("status", umc.study.domain.enums.MissionStatus.class);

    public final NumberPath<Integer> storeId = createNumber("storeId", Integer.class);

    public final ListPath<Store, QStore> storeList = this.<Store, QStore>createList("storeList", Store.class, QStore.class, PathInits.DIRECT2);

    public final QUser user;

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

