package umc.study.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.service.MemberCommandService;
import umc.study.domain.review.converter.ReviewConverter;
import umc.study.domain.review.dto.ReviewRequestDto;
import umc.study.domain.review.dto.ReviewResponseDto;
import umc.study.domain.review.entity.Review;
import umc.study.domain.review.repository.ReviewRepository;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.service.StoreService;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final MemberCommandService memberCommandService;
    private final StoreService storeService;
    private final ReviewConverter reviewConverter;

    @Override
    public ReviewResponseDto createReview(ReviewRequestDto request) {
        Long memberId = request.getMemberId();
        Long storeId = request.getStoreId();
        Member member = memberCommandService.findMemberById(memberId);
        Store store = storeService.findStoreById(storeId);
        Review newReview = reviewConverter.toReview(request, member, store);
        reviewRepository.save(newReview);
        return reviewConverter.toReviewResponseDto(newReview);
    }
}
