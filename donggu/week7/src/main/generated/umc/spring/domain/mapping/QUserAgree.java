package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAgree is a Querydsl query type for UserAgree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAgree extends EntityPathBase<UserAgree> {

    private static final long serialVersionUID = -322269867L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAgree userAgree = new QUserAgree("userAgree");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.term.domain.QTerm term;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.user.domain.QUser user;

    public final NumberPath<Long> userAgreementId = createNumber("userAgreementId", Long.class);

    public QUserAgree(String variable) {
        this(UserAgree.class, forVariable(variable), INITS);
    }

    public QUserAgree(Path<? extends UserAgree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAgree(PathMetadata metadata, PathInits inits) {
        this(UserAgree.class, metadata, inits);
    }

    public QUserAgree(Class<? extends UserAgree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.term = inits.isInitialized("term") ? new umc.spring.domain.term.domain.QTerm(forProperty("term")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

