package umc.spring.domain.term.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerm is a Querydsl query type for Term
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerm extends EntityPathBase<Term> {

    private static final long serialVersionUID = 1179506048L;

    public static final QTerm term = new QTerm("term");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath termCategory = createString("termCategory");

    public final StringPath termContent = createString("termContent");

    public final NumberPath<Long> termId = createNumber("termId", Long.class);

    public final EnumPath<umc.spring.domain.shared.TermType> termType = createEnum("termType", umc.spring.domain.shared.TermType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.UserAgree, umc.spring.domain.mapping.QUserAgree> userAgreeList = this.<umc.spring.domain.mapping.UserAgree, umc.spring.domain.mapping.QUserAgree>createList("userAgreeList", umc.spring.domain.mapping.UserAgree.class, umc.spring.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public QTerm(String variable) {
        super(Term.class, forVariable(variable));
    }

    public QTerm(Path<? extends Term> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerm(PathMetadata metadata) {
        super(Term.class, metadata);
    }

}

