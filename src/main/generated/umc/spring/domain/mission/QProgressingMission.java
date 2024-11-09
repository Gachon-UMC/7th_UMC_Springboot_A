package umc.spring.domain.mission;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProgressingMission is a Querydsl query type for ProgressingMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProgressingMission extends EntityPathBase<ProgressingMission> {

    private static final long serialVersionUID = 130595461L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgressingMission progressingMission = new QProgressingMission("progressingMission");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMission mission;

    public final umc.spring.domain.user.QUsers user;

    public QProgressingMission(String variable) {
        this(ProgressingMission.class, forVariable(variable), INITS);
    }

    public QProgressingMission(Path<? extends ProgressingMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProgressingMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProgressingMission(PathMetadata metadata, PathInits inits) {
        this(ProgressingMission.class, metadata, inits);
    }

    public QProgressingMission(Class<? extends ProgressingMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.user.QUsers(forProperty("user")) : null;
    }

}

