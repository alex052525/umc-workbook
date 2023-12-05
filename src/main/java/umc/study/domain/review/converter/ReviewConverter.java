package umc.study.domain.review.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.member.entity.Member;
import umc.study.domain.review.dto.ReviewCreateRequestDto;
import umc.study.domain.review.dto.ReviewCreateResponseDto;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.entity.Store;

@Component
public class ReviewConverter {
    public Review toReview(ReviewCreateRequestDto request, Member member, Store store) {
        return Review.builder()
                .body(request.getBody())
                .rating(request.getRating())
                .member(member)
                .store(store)
                .build();
    }

    public ReviewCreateResponseDto toReviewResponseDto(Review review) {
        return ReviewCreateResponseDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
