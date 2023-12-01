package umc.study.domain.review.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ReviewRequestDto {
    @NotBlank
    private String title;

    @NotNull
    private Float rating;

    @NotNull
    private Long memberId;

    @NotNull
    private Long storeId;
}
