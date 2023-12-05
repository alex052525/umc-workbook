package umc.study.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.member.entity.Member;
import umc.study.domain.review.converter.ReviewConverter;
import umc.study.domain.review.dto.ReviewCreateRequestDto;
import umc.study.domain.review.dto.ReviewCreateResponseDto;
import umc.study.domain.review.entity.Review;
import umc.study.domain.review.repository.ReviewRepository;
import umc.study.domain.store.entity.Store;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;


    @Override
    public Page<Review> findAllByStore(Store store, PageRequest pageRequest) {
        return reviewRepository.findAllByStore(store, pageRequest);
    }

    @Override
    public ReviewCreateResponseDto createReview(ReviewCreateRequestDto request, Member member, Store store) {
        Review newReview = reviewConverter.toReview(request, member, store);
        reviewRepository.save(newReview);
        return reviewConverter.toReviewResponseDto(newReview);
    }
}
