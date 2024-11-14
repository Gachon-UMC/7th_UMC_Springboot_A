package umc.spring.domain.help.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHelp is a Querydsl query type for Help
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHelp extends EntityPathBase<Help> {

    private static final long serialVersionUID = 868766634L;

    public static final QHelp help = new QHelp("help");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath helpCategory = createString("helpCategory");

    public final StringPath helpContent = createString("helpContent");

    public final NumberPath<Long> helpId = createNumber("helpId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QHelp(String variable) {
        super(Help.class, forVariable(variable));
    }

    public QHelp(Path<? extends Help> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHelp(PathMetadata metadata) {
        super(Help.class, metadata);
    }

}

