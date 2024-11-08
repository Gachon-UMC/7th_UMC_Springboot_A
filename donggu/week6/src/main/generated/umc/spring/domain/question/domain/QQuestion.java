package umc.spring.domain.question.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = -1749368716L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestion question = new QQuestion("question");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    public final umc.spring.domain.answer.domain.QAnswer answer;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final ListPath<umc.spring.domain.questionMedia.domain.QuestionMedia, umc.spring.domain.questionMedia.domain.QQuestionMedia> questionMediaList = this.<umc.spring.domain.questionMedia.domain.QuestionMedia, umc.spring.domain.questionMedia.domain.QQuestionMedia>createList("questionMediaList", umc.spring.domain.questionMedia.domain.QuestionMedia.class, umc.spring.domain.questionMedia.domain.QQuestionMedia.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.shared.QuestionStatus> questionStatus = createEnum("questionStatus", umc.spring.domain.shared.QuestionStatus.class);

    public final EnumPath<umc.spring.domain.shared.QuestionType> questionType = createEnum("questionType", umc.spring.domain.shared.QuestionType.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.user.domain.QUser user;

    public QQuestion(String variable) {
        this(Question.class, forVariable(variable), INITS);
    }

    public QQuestion(Path<? extends Question> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestion(PathMetadata metadata, PathInits inits) {
        this(Question.class, metadata, inits);
    }

    public QQuestion(Class<? extends Question> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.answer = inits.isInitialized("answer") ? new umc.spring.domain.answer.domain.QAnswer(forProperty("answer"), inits.get("answer")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

