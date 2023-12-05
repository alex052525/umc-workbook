package umc.study.domain.review.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPreViewDTO{
    String ownerNickname;
    Float rating;
    String body;
    LocalDate createdAt;
}