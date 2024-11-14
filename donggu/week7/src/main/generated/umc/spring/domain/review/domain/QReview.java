package umc.spring.domain.review.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -94402984L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final umc.spring.domain.reply.domain.QReply reply;

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public final ListPath<umc.spring.domain.reviewMedia.domain.ReviewMedia, umc.spring.domain.reviewMedia.domain.QReviewMedia> reviewMediaList = this.<umc.spring.domain.reviewMedia.domain.ReviewMedia, umc.spring.domain.reviewMedia.domain.QReviewMedia>createList("reviewMediaList", umc.spring.domain.reviewMedia.domain.ReviewMedia.class, umc.spring.domain.reviewMedia.domain.QReviewMedia.class, PathInits.DIRECT2);

    public final umc.spring.domain.store.domain.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.user.domain.QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reply = inits.isInitialized("reply") ? new umc.spring.domain.reply.domain.QReply(forProperty("reply"), inits.get("reply")) : null;
        this.store = inits.isInitialized("store") ? new umc.spring.domain.store.domain.QStore(forProperty("store"), inits.get("store")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

