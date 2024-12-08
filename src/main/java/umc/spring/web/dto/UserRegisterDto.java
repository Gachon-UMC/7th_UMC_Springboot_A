package umc.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.user.Gender;
import umc.spring.domain.user.UserType;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegisterDto {

    @NotBlank
    private String name;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate birth;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNum;

    @NotNull
    private UserType userType;

    @Email
    @NotBlank
    private String email;

    private Integer point;

    @NotNull
    private String pushNewEvent;

    @NotNull
    private String pushReviewAnswer;

    @NotNull
    private String pushInquiryAnswer;
}
