package umc.spring.domain.review.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.reply.domain.Reply;
import umc.spring.domain.review.reviewMedia.domain.ReviewMedia;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	@NotNull
	@Column
	private int rating;

	@NotNull
	@Column
	private String comment;

	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
	private List<ReviewMedia> reviewMediaList = new ArrayList<>();

	@OneToOne(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Reply reply;

	@Builder
	private Review(User user, Store store, int rating, String comment) {
		this.user = user;
		this.store = store;
		this.rating = rating;
		this.comment = comment;
	}

	public static Review createReview(User user, Store store, int rating, String comment) {
		return Review.builder()
			.user(user)
			.store(store)
			.rating(rating)
			.comment(comment)
			.build();
	}

}
