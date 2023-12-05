package umc.study.domain.store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.review.dto.ReviewCreateRequestDto;
import umc.study.domain.review.dto.ReviewCreateResponseDto;
import umc.study.domain.review.dto.ReviewPreViewListDTO;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.dto.StoreCreateRequestDTO;
import umc.study.domain.store.dto.StoreCreateResponseDTO;
import umc.study.domain.store.entity.Store;

public interface StoreService {
    StoreCreateResponseDTO createStore(StoreCreateRequestDTO request);
    Store findStoreById(Long id);

    ReviewCreateResponseDto createReview(ReviewCreateRequestDto request);
}
