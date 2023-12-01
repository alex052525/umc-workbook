package umc.study.domain.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.region.entity.Region;
import umc.study.domain.region.service.RegionService;
import umc.study.domain.store.converter.StoreConverter;
import umc.study.domain.store.dto.StoreRequestDTO;
import umc.study.domain.store.dto.StoreResponseDTO;
import umc.study.domain.store.entity.Store;
import umc.study.domain.store.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;
    private final RegionService regionService;
    private final StoreConverter storeConverter;

    @Override
    public StoreResponseDTO createStore(StoreRequestDTO request) {
        Long regionId = request.getRegionId();
        Region region = regionService.findByRegionId(regionId);
        Store newStore = storeConverter.toStore(request, region);
        storeRepository.save(newStore);
        return storeConverter.toStoreResponseDto(newStore);
    }
}
