package umc.spring.domain.user.domain;

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

    private static final long serialVersionUID = 1110183358L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final umc.spring.domain.shared.QBaseTimeEntity _super = new umc.spring.domain.shared.QBaseTimeEntity(this);

    public final StringPath address = createString("address");

    public final QBirthDay birth;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath customId = createString("customId");

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.shared.Gender> gender = createEnum("gender", umc.spring.domain.shared.Gender.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveDate = createDateTime("inactiveDate", java.time.LocalDateTime.class);

    public final ListPath<umc.spring.domain.mapping.UserAgree, umc.spring.domain.mapping.QUserAgree> memberAgreeList = this.<umc.spring.domain.mapping.UserAgree, umc.spring.domain.mapping.QUserAgree>createList("memberAgreeList", umc.spring.domain.mapping.UserAgree.class, umc.spring.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.UserMission, umc.spring.domain.mapping.QUserMission> memberMissionList = this.<umc.spring.domain.mapping.UserMission, umc.spring.domain.mapping.QUserMission>createList("memberMissionList", umc.spring.domain.mapping.UserMission.class, umc.spring.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.UserPrefer, umc.spring.domain.mapping.QUserPrefer> memberPreferList = this.<umc.spring.domain.mapping.UserPrefer, umc.spring.domain.mapping.QUserPrefer>createList("memberPreferList", umc.spring.domain.mapping.UserPrefer.class, umc.spring.domain.mapping.QUserPrefer.class, PathInits.DIRECT2);

    public final NumberPath<Integer> missionCount = createNumber("missionCount", Integer.class);

    public final StringPath nickname = createString("nickname");

    public final ListPath<umc.spring.domain.notification.domain.Notification, umc.spring.domain.notification.domain.QNotification> notificationList = this.<umc.spring.domain.notification.domain.Notification, umc.spring.domain.notification.domain.QNotification>createList("notificationList", umc.spring.domain.notification.domain.Notification.class, umc.spring.domain.notification.domain.QNotification.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<umc.spring.domain.point.domain.Point, umc.spring.domain.point.domain.QPoint> pointList = this.<umc.spring.domain.point.domain.Point, umc.spring.domain.point.domain.QPoint>createList("pointList", umc.spring.domain.point.domain.Point.class, umc.spring.domain.point.domain.QPoint.class, PathInits.DIRECT2);

    public final StringPath profileImageUrl = createString("profileImageUrl");

    public final StringPath refreshToken = createString("refreshToken");

    public final ListPath<umc.spring.domain.reply.domain.Reply, umc.spring.domain.reply.domain.QReply> replyList = this.<umc.spring.domain.reply.domain.Reply, umc.spring.domain.reply.domain.QReply>createList("replyList", umc.spring.domain.reply.domain.Reply.class, umc.spring.domain.reply.domain.QReply.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.review.domain.Review, umc.spring.domain.review.domain.QReview> reviewList = this.<umc.spring.domain.review.domain.Review, umc.spring.domain.review.domain.QReview>createList("reviewList", umc.spring.domain.review.domain.Review.class, umc.spring.domain.review.domain.QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.shared.SocialStatus> socialStatus = createEnum("socialStatus", umc.spring.domain.shared.SocialStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public final EnumPath<umc.spring.domain.shared.UserStatus> userStatus = createEnum("userStatus", umc.spring.domain.shared.UserStatus.class);

    public final EnumPath<umc.spring.domain.shared.UserType> userType = createEnum("userType", umc.spring.domain.shared.UserType.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.birth = inits.isInitialized("birth") ? new QBirthDay(forProperty("birth")) : null;
    }

}

