package umc.study.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    public UserQueryServiceImpl(UserRepository userRepository, ReviewRepository reviewRepository, MissionRepository missionRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.missionRepository = missionRepository;
    }

    @Override
    public Page<Review> getUserReviewList(Integer userId, Integer page) {
        User user = userRepository.findById(userId).get();

        Page<Review> userPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));


        return userPage;
    }
    @Override
    public Page<Mission> getUserMissionList(Integer userId, Integer page) {
        User user = userRepository.findById(userId).get();

        Page<Mission> missionPage = missionRepository.findAllByUser(user, PageRequest.of(page, 10));


        return missionPage;
    }
}
