package umc.study.domain.store.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.region.entity.Region;
import umc.study.domain.store.dto.StoreRequestDTO;
import umc.study.domain.store.dto.StoreResponseDTO;
import umc.study.domain.store.entity.Store;

@Component
public class StoreConverter {
    public Store toStore(StoreRequestDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .info(request.getInfo())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public StoreResponseDTO toStoreResponseDto(Store store) {
        return StoreResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
