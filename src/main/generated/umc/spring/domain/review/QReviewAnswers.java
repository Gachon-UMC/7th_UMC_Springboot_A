package umc.spring.domain.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewAnswers is a Querydsl query type for ReviewAnswers
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewAnswers extends EntityPathBase<ReviewAnswers> {

    private static final long serialVersionUID = 973802579L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewAnswers reviewAnswers = new QReviewAnswers("reviewAnswers");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReview review;

    public QReviewAnswers(String variable) {
        this(ReviewAnswers.class, forVariable(variable), INITS);
    }

    public QReviewAnswers(Path<? extends ReviewAnswers> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewAnswers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewAnswers(PathMetadata metadata, PathInits inits) {
        this(ReviewAnswers.class, metadata, inits);
    }

    public QReviewAnswers(Class<? extends ReviewAnswers> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

