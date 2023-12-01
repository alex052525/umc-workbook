package umc.study.domain.review.service;

import umc.study.domain.review.dto.ReviewRequestDto;
import umc.study.domain.review.dto.ReviewResponseDto;

public interface ReviewService {
    ReviewResponseDto createReview(ReviewRequestDto request);
}
