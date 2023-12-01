package umc.study.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
