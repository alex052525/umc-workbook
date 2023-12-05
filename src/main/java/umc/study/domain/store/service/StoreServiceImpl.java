package umc.study.domain.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.service.MemberCommandService;
import umc.study.domain.mission.dto.MissionPreViewListDTO;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.service.MissionService;
import umc.study.domain.region.entity.Region;
import umc.study.domain.region.service.RegionService;
import umc.study.domain.review.dto.ReviewCreateRequestDto;
import umc.study.domain.review.dto.ReviewCreateResponseDto;
import umc.study.domain.review.dto.ReviewPreViewListDTO;
import umc.study.domain.review.entity.Review;
import umc.study.domain.review.service.ReviewService;
import umc.study.domain.store.converter.StoreConverter;
import umc.study.domain.store.dto.StoreCreateRequestDTO;
import umc.study.domain.store.dto.StoreCreateResponseDTO;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.repository.StoreRepository;
import umc.study.global.apipayload.code.status.ErrorStatus;
import umc.study.global.exception.GeneralException;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;
    private final RegionService regionService;
    private final StoreConverter storeConverter;
    private final ReviewService reviewService;
    private final MemberCommandService memberCommandService;
    private final MissionService missionService;
    private static final Integer REVIEW_PAGE_SIZE = 10;
    private static final Integer MISSION_PAGE_SIZE = 10;
    @Override
    public StoreCreateResponseDTO createStore(StoreCreateRequestDTO request) {
        Long regionId = request.getRegionId();
        Region region = regionService.findByRegionId(regionId);
        Store newStore = storeConverter.toStore(request, region);
        storeRepository.save(newStore);
        return storeConverter.toStoreResponseDto(newStore);
    }

    @Override
    public Store findStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatus.REGION_NOT_FOUND)
        );
    }

    @Override
    public Page<Review> findAllReviewByStore(Store store, PageRequest pageRequest) {
        return reviewService.findAllByStore(store, pageRequest);
    }

    @Override
    public ReviewPreViewListDTO getReviewList(Long StoreId, Integer page) {
        Store store = findStoreById(StoreId);
        Page<Review> storePage = findAllReviewByStore(store, PageRequest.of(page, REVIEW_PAGE_SIZE));
        return storeConverter.toReviewPreViewListDTO(storePage);
    }

    @Override
    public Page<Mission> findAllMissionByStore(Store store, PageRequest pageRequest) {
        return missionService.findAllByStore(store, pageRequest);
    }

    @Override
    public MissionPreViewListDTO getMissionList(Long StoreId, Integer page) {
        Store store = findStoreById(StoreId);
        Page<Mission> storePage = findAllMissionByStore(store, PageRequest.of(page,MISSION_PAGE_SIZE));
        return storeConverter.toMissionPreViewListDTO(storePage);
    }

    @Override
    public ReviewCreateResponseDto createReview(ReviewCreateRequestDto request) {
        Long memberId = request.getMemberId();
        Long storeId = request.getStoreId();
        Member member = memberCommandService.findMemberById(memberId);
        Store store = findStoreById(storeId);
        return reviewService.createReview(request, member, store);
    }
}
