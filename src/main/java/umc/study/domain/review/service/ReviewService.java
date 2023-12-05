package umc.study.domain.review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.member.entity.Member;
import umc.study.domain.review.dto.ReviewCreateRequestDto;
import umc.study.domain.review.dto.ReviewCreateResponseDto;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.entity.Store;

public interface ReviewService {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    ReviewCreateResponseDto createReview(ReviewCreateRequestDto request, Member member, Store store);
}
