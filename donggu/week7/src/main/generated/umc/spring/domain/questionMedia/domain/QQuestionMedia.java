package umc.spring.domain.questionMedia.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionMedia is a Querydsl query type for QuestionMedia
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionMedia extends EntityPathBase<QuestionMedia> {

    private static final long serialVersionUID = -1133126224L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionMedia questionMedia = new QQuestionMedia("questionMedia");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.question.domain.QQuestion question;

    public final StringPath questionFilePath = createString("questionFilePath");

    public final NumberPath<Long> QuestionMediaId = createNumber("QuestionMediaId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QQuestionMedia(String variable) {
        this(QuestionMedia.class, forVariable(variable), INITS);
    }

    public QQuestionMedia(Path<? extends QuestionMedia> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionMedia(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionMedia(PathMetadata metadata, PathInits inits) {
        this(QuestionMedia.class, metadata, inits);
    }

    public QQuestionMedia(Class<? extends QuestionMedia> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new umc.spring.domain.question.domain.QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

