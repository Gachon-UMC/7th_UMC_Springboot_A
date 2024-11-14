package umc.spring.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBirthDay is a Querydsl query type for BirthDay
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBirthDay extends BeanPath<BirthDay> {

    private static final long serialVersionUID = 1570364112L;

    public static final QBirthDay birthDay = new QBirthDay("birthDay");

    public final NumberPath<Integer> day = createNumber("day", Integer.class);

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QBirthDay(String variable) {
        super(BirthDay.class, forVariable(variable));
    }

    public QBirthDay(Path<? extends BirthDay> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBirthDay(PathMetadata metadata) {
        super(BirthDay.class, metadata);
    }

}

