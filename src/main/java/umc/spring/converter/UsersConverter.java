package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.user.Users;
import umc.spring.dto.UserRegisterDto;
import umc.spring.domain.user.AlarmStatus;

@Component
public class UsersConverter {

    public Users toEntity(UserRegisterDto request) {
        return Users.builder()
                .name(request.getName())
                .gender(request.getGender())
                .birth(request.getBirth())
                .address(request.getAddress())
                .phoneNum(request.getPhoneNum())
                .userType(request.getUserType())
                .email(request.getEmail())
                .point(request.getPoint() != null ? request.getPoint() : 0)
                .pushNewEvent(AlarmStatus.valueOf(request.getPushNewEvent()))
                .pushReviewAnswer(AlarmStatus.valueOf(request.getPushReviewAnswer()))
                .pushInquiryAnswer(AlarmStatus.valueOf(request.getPushInquiryAnswer()))
                .build();
    }
}
