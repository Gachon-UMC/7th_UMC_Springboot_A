package umc.spring.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 1846292369L;

    public static final QUsers users = new QUsers("users");

    public final umc.spring.global.QBaseEntity _super = new umc.spring.global.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<umc.spring.domain.Alarm.Alarm, umc.spring.domain.Alarm.QAlarm> alarmList = this.<umc.spring.domain.Alarm.Alarm, umc.spring.domain.Alarm.QAlarm>createList("alarmList", umc.spring.domain.Alarm.Alarm.class, umc.spring.domain.Alarm.QAlarm.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ListPath<umc.spring.domain.food.FoodList, umc.spring.domain.food.QFoodList> foodListList = this.<umc.spring.domain.food.FoodList, umc.spring.domain.food.QFoodList>createList("foodListList", umc.spring.domain.food.FoodList.class, umc.spring.domain.food.QFoodList.class, PathInits.DIRECT2);

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.inquiry.Inquiry, umc.spring.domain.inquiry.QInquiry> inquiryList = this.<umc.spring.domain.inquiry.Inquiry, umc.spring.domain.inquiry.QInquiry>createList("inquiryList", umc.spring.domain.inquiry.Inquiry.class, umc.spring.domain.inquiry.QInquiry.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<umc.spring.domain.mission.ProgressingMission, umc.spring.domain.mission.QProgressingMission> progressingMissionList = this.<umc.spring.domain.mission.ProgressingMission, umc.spring.domain.mission.QProgressingMission>createList("progressingMissionList", umc.spring.domain.mission.ProgressingMission.class, umc.spring.domain.mission.QProgressingMission.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.Alarm.AlarmStatus> pushInquiryAnswer = createEnum("pushInquiryAnswer", umc.spring.domain.Alarm.AlarmStatus.class);

    public final EnumPath<umc.spring.domain.Alarm.AlarmStatus> pushNewEvent = createEnum("pushNewEvent", umc.spring.domain.Alarm.AlarmStatus.class);

    public final EnumPath<umc.spring.domain.Alarm.AlarmStatus> pushReviewAnswer = createEnum("pushReviewAnswer", umc.spring.domain.Alarm.AlarmStatus.class);

    public final ListPath<umc.spring.domain.review.Review, umc.spring.domain.review.QReview> reviewList = this.<umc.spring.domain.review.Review, umc.spring.domain.review.QReview>createList("reviewList", umc.spring.domain.review.Review.class, umc.spring.domain.review.QReview.class, PathInits.DIRECT2);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final EnumPath<UserType> userType = createEnum("userType", UserType.class);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

