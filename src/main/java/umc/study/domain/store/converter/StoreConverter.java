package umc.study.domain.store.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.domain.mission.dto.MissionPreViewDTO;
import umc.study.domain.mission.dto.MissionPreViewListDTO;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.region.entity.Region;
import umc.study.domain.review.dto.ReviewPreViewDTO;
import umc.study.domain.review.dto.ReviewPreViewListDTO;
import umc.study.domain.review.entity.Review;
import umc.study.domain.store.dto.StoreCreateRequestDTO;
import umc.study.domain.store.dto.StoreCreateResponseDTO;
import umc.study.domain.store.entity.Store;

@Component
public class StoreConverter {
    public Store toStore(StoreCreateRequestDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .info(request.getInfo())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public StoreCreateResponseDTO toStoreResponseDto(Store store) {
        return StoreCreateResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return ReviewPreViewDTO.builder()
            .ownerNickname(review.getMember().getName())
            .rating(review.getRating())
            .createdAt(review.getCreatedAt().toLocalDate())
            .body(review.getBody())
            .build();
    }

    public ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
            .map(this::toReviewPreViewDTO).collect(Collectors.toList());

        return ReviewPreViewListDTO.builder()
            .isLast(reviewList.isLast())
            .isFirst(reviewList.isFirst())
            .totalPage(reviewList.getTotalPages())
            .totalElements(reviewList.getTotalElements())
            .listSize(reviewPreViewDTOList.size())
            .reviewList(reviewPreViewDTOList)
            .build();
    }

    public MissionPreViewDTO toMissionPreViewDTO(Mission mission) {
        return MissionPreViewDTO.builder()
            .storeName(mission.getStore().getName())
            .description(mission.getDescription())
            .reward(mission.getReward())
            .createdAt(mission.getCreatedAt().toLocalDate())
            .build();
    }

    public MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionList) {
        List<MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
            .map(this::toMissionPreViewDTO).collect(Collectors.toList());

        return MissionPreViewListDTO.builder()
            .isLast(missionList.isLast())
            .isFirst(missionList.isFirst())
            .totalPage(missionList.getTotalPages())
            .totalElements(missionList.getTotalElements())
            .listSize(missionPreViewDTOList.size())
            .missionList(missionPreViewDTOList)
            .build();
    }
}
