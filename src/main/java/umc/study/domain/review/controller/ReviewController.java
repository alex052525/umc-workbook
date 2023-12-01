package umc.study.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.domain.review.dto.ReviewRequestDto;
import umc.study.domain.review.dto.ReviewResponseDto;
import umc.study.domain.review.service.ReviewService;
import umc.study.global.apipayload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDto> createReview(@RequestBody @Valid
                                                       ReviewRequestDto request) {
        ReviewResponseDto response = reviewService.createReview(request);
        return ApiResponse.onSuccess(response);
    }
}
