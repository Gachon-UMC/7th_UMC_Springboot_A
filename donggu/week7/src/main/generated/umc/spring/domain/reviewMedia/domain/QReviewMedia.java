package umc.spring.domain.reviewMedia.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewMedia is a Querydsl query type for ReviewMedia
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewMedia extends EntityPathBase<ReviewMedia> {

    private static final long serialVersionUID = 1483837040L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewMedia reviewMedia = new QReviewMedia("reviewMedia");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> mediaId = createNumber("mediaId", Long.class);

    public final umc.spring.domain.review.domain.QReview review;

    public final StringPath reviewFilePath = createString("reviewFilePath");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewMedia(String variable) {
        this(ReviewMedia.class, forVariable(variable), INITS);
    }

    public QReviewMedia(Path<? extends ReviewMedia> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewMedia(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewMedia(PathMetadata metadata, PathInits inits) {
        this(ReviewMedia.class, metadata, inits);
    }

    public QReviewMedia(Class<? extends ReviewMedia> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new umc.spring.domain.review.domain.QReview(forProperty("review"), inits.get("review")) : null;
    }

}

