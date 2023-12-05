package umc.study.domain.review.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ReviewCreateRequestDto {
    @NotBlank
    private String body;

    @NotNull
    private Float rating;

    @NotNull
    private Long memberId;

    @NotNull
    private Long storeId;
}
