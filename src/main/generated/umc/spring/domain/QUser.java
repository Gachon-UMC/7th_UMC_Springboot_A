package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1348045193L;

    public static final QUser user = new QUser("user");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthDay = createDate("birthDay", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.emums.Gender> gender = createEnum("gender", umc.spring.domain.emums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<umc.spring.domain.emums.SocialType> loginMethod = createEnum("loginMethod", umc.spring.domain.emums.SocialType.class);

    public final ListPath<umc.spring.domain.mapping.Inquiry, umc.spring.domain.mapping.QInquiry> memberInquiry = this.<umc.spring.domain.mapping.Inquiry, umc.spring.domain.mapping.QInquiry>createList("memberInquiry", umc.spring.domain.mapping.Inquiry.class, umc.spring.domain.mapping.QInquiry.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.Login, umc.spring.domain.mapping.QLogin> memberLogin = this.<umc.spring.domain.mapping.Login, umc.spring.domain.mapping.QLogin>createList("memberLogin", umc.spring.domain.mapping.Login.class, umc.spring.domain.mapping.QLogin.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> memberReview = this.<Review, QReview>createList("memberReview", Review.class, QReview.class, PathInits.DIRECT2);

    public final ListPath<UserMission, QUserMission> memberUserMission = this.<UserMission, QUserMission>createList("memberUserMission", UserMission.class, QUserMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<UserPrefer, QUserPrefer> userPrefers = this.<UserPrefer, QUserPrefer>createList("userPrefers", UserPrefer.class, QUserPrefer.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

