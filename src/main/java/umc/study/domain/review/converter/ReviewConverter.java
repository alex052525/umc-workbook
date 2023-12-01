package umc.study.domain.review.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.member.entity.Member;
import umc.study.domain.review.dto.ReviewRequestDto;
import umc.study.domain.review.dto.ReviewResponseDto;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.entity.Store;

@Component
public class ReviewConverter {
    public Review toReview(ReviewRequestDto request, Member member, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .rating(request.getRating())
                .member(member)
                .store(store)
                .build();
    }

    public ReviewResponseDto toReviewResponseDto(Review review) {
        return ReviewResponseDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
