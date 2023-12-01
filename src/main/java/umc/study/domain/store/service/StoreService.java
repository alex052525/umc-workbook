package umc.study.domain.store.service;

import umc.study.domain.store.dto.StoreRequestDTO;
import umc.study.domain.store.dto.StoreResponseDTO;
import umc.study.domain.store.entity.Store;

public interface StoreService {
    StoreResponseDTO createStore(StoreRequestDTO request);
    Store findStoreById(Long id);
}
